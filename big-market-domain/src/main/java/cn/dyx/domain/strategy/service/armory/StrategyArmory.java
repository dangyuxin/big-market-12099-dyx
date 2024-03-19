package cn.dyx.domain.strategy.service.armory;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;
import cn.dyx.domain.strategy.repositoty.IStrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class StrategyArmory implements IStrategyArmory {

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public void assembleLotteryStrategy(Long strategyId) {
        // 1.查询策略配置
        List<StrategyAwardEntity> list = strategyRepository.queryStrategyAwardList(strategyId);

        //2.获取最小概率值
        BigDecimal minAwardRate =
                list.stream().map(StrategyAwardEntity::getAwardRate).min(BigDecimal::compareTo).orElse(BigDecimal.ZERO);

        //3.获取概率值总和
        BigDecimal total = list.stream().map(StrategyAwardEntity::getAwardRate).reduce(BigDecimal.ZERO,
                BigDecimal::add);

        //4.计算概率范围大小
        BigDecimal rateRange = total.divide(minAwardRate, 0, BigDecimal.ROUND_CEILING);

        //5.制作概率查找表
        ArrayList<Integer> strategyAwardSearchRateTable = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAwardEntity : list) {
            Integer awardId = strategyAwardEntity.getAwardId();
            BigDecimal awardRate = strategyAwardEntity.getAwardRate();
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0, BigDecimal.ROUND_CEILING).intValue(); i++) {
                strategyAwardSearchRateTable.add(awardId);
            }
        }

        //6.乱序概率表
        Collections.shuffle(strategyAwardSearchRateTable);


        //7，创建集合存储
        HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTable = new HashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTable.size(); i++) {
            shuffleStrategyAwardSearchRateTable.put(i,strategyAwardSearchRateTable.get(i));
        }

        //8.Redis存储集合
        strategyRepository.storeStrategyAwardSearchRateTable(strategyId,strategyAwardSearchRateTable.size(),shuffleStrategyAwardSearchRateTable);


    }

    @Override
    public Integer getRandomAwardId(Long strategyId) {

        int rateRange = strategyRepository.getRateRange(strategyId);


        return strategyRepository.getStrategyAwardAssemble(strategyId,new SecureRandom().nextInt(rateRange));
    }
}
