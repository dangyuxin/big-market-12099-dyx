package cn.dyx.domain.strategy.repositoty;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;
import cn.dyx.domain.strategy.model.entity.StrategyEntity;
import cn.dyx.domain.strategy.model.entity.StrategyRuleEntity;
import cn.dyx.domain.strategy.model.vo.RuleTreeVO;
import cn.dyx.domain.strategy.model.vo.StrategyAwardRuleModelVO;
import cn.dyx.domain.strategy.model.vo.StrategyAwardStockKeyVO;

import java.util.HashMap;
import java.util.List;

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, int rateRange,
                                           HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTable);

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

    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);

    StrategyAwardStockKeyVO takeQueueValue();

    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);
}
