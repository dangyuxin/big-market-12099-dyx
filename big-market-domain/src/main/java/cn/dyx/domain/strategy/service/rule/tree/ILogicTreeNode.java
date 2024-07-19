package cn.dyx.domain.strategy.service.rule.tree;

import cn.dyx.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * @author dyx
 * @description 规则树接口
 * @create 2024/4/18 10:20
 */
public interface ILogicTreeNode {
    DefaultTreeFactory.TreeActionEntity logics(String userId, Long strategyId, Integer awardId, String ruleValue,
                                               Date endDateTime);
}
