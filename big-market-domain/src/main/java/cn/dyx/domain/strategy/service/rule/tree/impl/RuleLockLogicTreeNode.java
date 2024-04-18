package cn.dyx.domain.strategy.service.rule.tree.impl;

import cn.dyx.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.dyx.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import cn.dyx.domain.strategy.model.vo.RuleLogicCheckTypeVO;

/**
 * @author dyx
 * @description 次数锁节点
 * @create 2024/4/18 15:34
 */
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logics(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                .build();
    }
}
