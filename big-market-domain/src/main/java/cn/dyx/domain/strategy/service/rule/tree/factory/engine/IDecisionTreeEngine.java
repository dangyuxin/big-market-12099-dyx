package cn.dyx.domain.strategy.service.rule.tree.factory.engine;

import cn.dyx.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author dyx
 * @description 执行引擎
 * @create 2024/4/18 15:41
 */
public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);
}
