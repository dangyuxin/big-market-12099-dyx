package cn.dyx.domain.strategy.service.rule.tree.impl;

import cn.dyx.domain.strategy.model.vo.RuleLogicCheckTypeVO;
import cn.dyx.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.dyx.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dyx
 * @description 库存操作节点
 * @create 2024/4/18 15:36
 */
@Slf4j
@Component("rule_stock")
public class RuleStockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logics(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }
}
