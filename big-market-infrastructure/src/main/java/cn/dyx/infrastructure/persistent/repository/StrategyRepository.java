package cn.dyx.infrastructure.persistent.repository;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;
import cn.dyx.domain.strategy.model.entity.StrategyEntity;
import cn.dyx.domain.strategy.model.entity.StrategyRuleEntity;
import cn.dyx.domain.strategy.repositoty.IStrategyRepository;
import cn.dyx.infrastructure.persistent.dao.IStrategyAwardDao;
import cn.dyx.infrastructure.persistent.dao.IStrategyDao;
import cn.dyx.infrastructure.persistent.dao.IStrategyRuleDao;
import cn.dyx.infrastructure.persistent.po.Strategy;
import cn.dyx.infrastructure.persistent.po.StrategyAward;
import cn.dyx.infrastructure.persistent.po.StrategyRule;
import cn.dyx.infrastructure.persistent.redis.IRedisService;
import cn.dyx.types.common.Constants;
import org.redisson.api.RMap;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;


    @Resource
    private IStrategyAwardDao strategyAwardDao;

    @Resource
    private IStrategyRuleDao strategyRuleDao;

    @Resource
    private IRedisService redisService;

    @Override
    public List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_KEY + strategyId;
        List<StrategyAwardEntity> strategyAwardEntities = redisService.getValue(cacheKey);
        if (strategyAwardEntities != null && !strategyAwardEntities.isEmpty()) return strategyAwardEntities;

        //从库中读取数据
        List<StrategyAward> strategyAwards = strategyAwardDao.queryStrategyAwardListByStrategyId(strategyId);
        strategyAwardEntities = new ArrayList<>(strategyAwards.size());
        for (StrategyAward strategyAward : strategyAwards) {
            StrategyAwardEntity strategyAwardEntity =
                    StrategyAwardEntity.builder()
                            .awardId(strategyAward.getAwardId())
                            .awardCount(strategyAward.getAwardCount())
                            .awardCountSurplus(strategyAward.getAwardCountSurplus())
                            .awardRate(strategyAward.getAwardRate())
                            .strategyId(strategyId)
                            .build();
            strategyAwardEntities.add(strategyAwardEntity);
        }

        redisService.setValue(cacheKey, strategyAwardEntities);

        return strategyAwardEntities;
    }

    @Override
    public void storeStrategyAwardSearchRateTable(String key, int rateRange,
                                                  HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTable) {
        redisService.setValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + key, rateRange);
        RMap<Integer, Integer> cacheRateTable = redisService.getMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY + key);
        cacheRateTable.putAll(shuffleStrategyAwardSearchRateTable);
    }

    @Override
    public int getRateRange(Long strategyId) {
        return getRateRange(String.valueOf(strategyId));
    }

    @Override
    public int getRateRange(String key) {
        return redisService.getValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + key);
    }

    @Override
    public Integer getStrategyAwardAssemble(String key, int rateRange) {
        return redisService.getFromMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY + key, rateRange);
    }

    @Override
    public StrategyEntity getStrategyStrategyEntityByStrategyId(Long strategyId) {
        String cacheKey = Constants.RedisKey.STRATEGY_KEY + strategyId;
        StrategyEntity strategyEntity = redisService.getValue(cacheKey);
        if (strategyEntity != null) return strategyEntity;
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        StrategyEntity strategyRes =
                StrategyEntity.builder()
                        .strategyId(strategy.getStrategyId())
                        .strategyDesc(strategy.getStrategyDesc())
                        .ruleModels(strategy.getRuleModels())
                        .build();
        redisService.setValue(cacheKey, strategyEntity);
        return strategyRes;
    }

    @Override
    public StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel) {
        StrategyRule strategyRule = new StrategyRule();
        strategyRule.setStrategyId(strategyId);
        strategyRule.setRuleModel(ruleModel);

        StrategyRule strategyRuleRes = strategyRuleDao.queryStrategyRule(strategyRule);
        StrategyRuleEntity strategyRuleEntity =
                StrategyRuleEntity.builder().
                        strategyId(strategyRuleRes.getStrategyId())
                        .awardId(strategyRuleRes.getAwardId())
                        .ruleDesc(strategyRuleRes.getRuleDesc())
                        .ruleType(strategyRuleRes.getRuleType())
                        .ruleValue(strategyRuleRes.getRuleValue())
                        .ruleModel(strategyRuleRes.getRuleModel())
                        .build();
        return strategyRuleEntity;
    }

    @Override
    public String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel) {
        StrategyRule strategyRule = new StrategyRule();
        strategyRule.setStrategyId(strategyId);
        strategyRule.setAwardId(awardId);
        strategyRule.setRuleModel(ruleModel);
        return strategyRuleDao.queryStrategyRuleValue(strategyRule);
    }

    @Override
    public StrategyEntity queryStrategyEntityByStrategyId(Long strategyId) {
        // 优先从缓存获取
        String cacheKey = Constants.RedisKey.STRATEGY_KEY + strategyId;
        StrategyEntity strategyEntity = redisService.getValue(cacheKey);
        if (null != strategyEntity) return strategyEntity;
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        strategyEntity = StrategyEntity.builder()
                .strategyId(strategy.getStrategyId())
                .strategyDesc(strategy.getStrategyDesc())
                .ruleModels(strategy.getRuleModels())
                .build();
        redisService.setValue(cacheKey, strategyEntity);
        return strategyEntity;
    }

}
