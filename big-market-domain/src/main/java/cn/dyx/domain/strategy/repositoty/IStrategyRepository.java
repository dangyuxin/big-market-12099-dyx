package cn.dyx.domain.strategy.repositoty;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;
import cn.dyx.domain.strategy.model.entity.StrategyEntity;
import cn.dyx.domain.strategy.model.entity.StrategyRuleEntity;
import cn.dyx.domain.strategy.model.vo.RuleTreeVO;
import cn.dyx.domain.strategy.model.vo.RuleWeightVO;
import cn.dyx.domain.strategy.model.vo.StrategyAwardRuleModelVO;
import cn.dyx.domain.strategy.model.vo.StrategyAwardStockKeyVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, int rateRange,
                                           Map<Integer, Integer> shuffleStrategyAwardSearchRateTable);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int rateRange);

    StrategyEntity getStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleMode);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    String queryStrategyRuleValue(Long strategyId, String s);

    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);

    void cacheStrategyAwardCount(String key, Integer awardCount);

    Boolean substractionAwardStock(String key);

    /**
     * 缓存key，decr 方式扣减库存
     *
     * @param cacheKey    缓存Key
     * @param endDateTime 活动结束时间
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(String cacheKey, Date endDateTime);


    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);

    StrategyAwardStockKeyVO takeQueueValue();

    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);

    Long queryStrategyIdByActivityId(Long activityId);

    Integer queryTodayUserRaffleCount(String userId, Long strategyId);

    /**
     * 根据规则树ID集合查询奖品中加锁数量的配置「部分奖品需要抽奖N次解锁」
     *
     * @param treeIds 规则树ID值
     * @return key 规则树，value rule_lock 加锁值
     */
    Map<String, Integer> queryAwardRuleLockCount(String[] treeIds);

    Integer queryActivityAccountTotalUseCount(String userId, Long strategyId);

    List<RuleWeightVO> queryAwardRuleWeight(Long strategyId);
}
