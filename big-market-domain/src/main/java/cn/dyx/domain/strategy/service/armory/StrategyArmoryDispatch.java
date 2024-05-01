package cn.dyx.domain.strategy.service.armory;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;
import cn.dyx.domain.strategy.model.entity.StrategyEntity;
import cn.dyx.domain.strategy.model.entity.StrategyRuleEntity;
import cn.dyx.domain.strategy.repositoty.IStrategyRepository;
import cn.dyx.types.common.Constants;
import cn.dyx.types.enums.ResponseCode;
import cn.dyx.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.*;

@Service
@Slf4j
public class StrategyArmoryDispatch implements IStrategyArmory, IStrategyDispatch {

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public boolean assembleLotteryStrategy(Long strategyId) {
        // 1.查询策略配置
        List<StrategyAwardEntity> list = strategyRepository.queryStrategyAwardList(strategyId);
        assembleLotteryStrategy(String.valueOf(strategyId), list);

        // 缓存奖品库存 [用于decr扣减库存使用]
        for (StrategyAwardEntity strategyAwardEntity : list) {
            Integer awardId = strategyAwardEntity.getAwardId();
            Integer awardCount = strategyAwardEntity.getAwardCount();
            cacheStrategyAwardCount(strategyId,awardId,awardCount);
        }

        StrategyEntity strategyEntity = strategyRepository.getStrategyEntityByStrategyId(strategyId);
        String weight = strategyEntity.getWeight();
        if (weight == null)
            return true;

        StrategyRuleEntity strategyRuleEntity = strategyRepository.queryStrategyRule(strategyId, weight);
        if (strategyRuleEntity == null)
            throw new AppException(ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getCode(),
                    ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getInfo());
        Map<String, List<Integer>> ruleWeightValues = strategyRuleEntity.getRuleWeightValues();
        Set<String> keys = ruleWeightValues.keySet();
        for (String key : keys) {
            List<Integer> values = ruleWeightValues.get(key);
            ArrayList<StrategyAwardEntity> strategyAwardEntitiesClone = new ArrayList<>(list);
            strategyAwardEntitiesClone.removeIf(entity -> !values.contains(entity.getAwardId()));
            assembleLotteryStrategy(String.valueOf(strategyId).concat("_").concat(key), strategyAwardEntitiesClone);
        }

        return true;
    }

    private void cacheStrategyAwardCount(Long strategyId, Integer awardId, Integer awardCount) {
        String key = Constants.RedisKey.STRATEGY_AWARD_COUNT_KEY+strategyId+Constants.UNDERLINE+awardId;
        strategyRepository.cacheStrategyAwardCount(key,awardCount);
    }

    public void assembleLotteryStrategy(String key, List<StrategyAwardEntity> list) {
        //1.获取最小概率值
        BigDecimal minAwardRate =
                list.stream().map(StrategyAwardEntity::getAwardRate).min(BigDecimal::compareTo).orElse(BigDecimal.ZERO);

        //2.获取概率值总和
        BigDecimal total = list.stream().map(StrategyAwardEntity::getAwardRate).reduce(BigDecimal.ZERO,
                BigDecimal::add);

        //3.计算概率范围大小
        BigDecimal rateRange = total.divide(minAwardRate, 0, BigDecimal.ROUND_CEILING);

        //4.制作概率查找表
        ArrayList<Integer> strategyAwardSearchRateTable = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAwardEntity : list) {
            Integer awardId = strategyAwardEntity.getAwardId();
            BigDecimal awardRate = strategyAwardEntity.getAwardRate();
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0,
                    BigDecimal.ROUND_CEILING).intValue(); i++) {
                strategyAwardSearchRateTable.add(awardId);
            }
        }

        //5.乱序概率表
        Collections.shuffle(strategyAwardSearchRateTable);


        //6，创建集合存储
        HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTable = new HashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTable.size(); i++) {
            shuffleStrategyAwardSearchRateTable.put(i, strategyAwardSearchRateTable.get(i));
        }

        //7.Redis存储集合
        strategyRepository.storeStrategyAwardSearchRateTable(key, strategyAwardSearchRateTable.size(),
                shuffleStrategyAwardSearchRateTable);
    }


    @Override
    public Integer getRandomAwardId(Long strategyId) {
        int rateRange = strategyRepository.getRateRange(strategyId);
        return strategyRepository.getStrategyAwardAssemble(String.valueOf(strategyId),
                new SecureRandom().nextInt(rateRange));
    }

    @Override
    public Integer getRandomAwardId(Long strategyId, String ruleWeightValue) {
        String key = String.valueOf(strategyId).concat("_").concat(ruleWeightValue);
        int rateRange = strategyRepository.getRateRange(key);
        return strategyRepository.getStrategyAwardAssemble(key, new SecureRandom().nextInt(rateRange));
    }

    @Override
    public Boolean subtractionAwardStock(Long strategyId, Integer awardId) {
        String key = Constants.RedisKey.STRATEGY_AWARD_COUNT_KEY+strategyId+Constants.UNDERLINE+awardId;
        return strategyRepository.substractionAwardStock(key);
    }


}
