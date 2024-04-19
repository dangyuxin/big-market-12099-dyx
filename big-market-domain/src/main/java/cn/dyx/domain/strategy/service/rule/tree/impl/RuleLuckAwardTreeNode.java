package cn.dyx.domain.strategy.service.rule.tree.impl;

import cn.dyx.domain.strategy.model.vo.RuleLogicCheckTypeVO;
import cn.dyx.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.dyx.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dyx
 * @description 兜底奖节点
 * @create 2024/4/18 15:35
 */
@Slf4j
@Component("rule_luck_award")
public class RuleLuckAwardTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logics(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .strategyAwardVO(DefaultTreeFactory.StrategyAwardVO.builder()
                        .awardId(101)
                        .awardRuleValue("1,100")
                        .build())
                .build();
    }
}
