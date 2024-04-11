package cn.dyx.domain.strategy.service.rule.filter.impl;

import cn.dyx.domain.strategy.model.entity.RuleActionEntity;
import cn.dyx.domain.strategy.model.entity.RuleMatterEntity;
import cn.dyx.domain.strategy.model.vo.RuleLogicCheckTypeVO;
import cn.dyx.domain.strategy.repositoty.IStrategyRepository;
import cn.dyx.domain.strategy.service.annotation.LogicStrategy;
import cn.dyx.domain.strategy.service.rule.filter.ILogicFilter;
import cn.dyx.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dyx
 * @description 用户抽奖n次后，对应奖品可解锁
 * @create 2024/4/2 16:20
 */
@Component
@Slf4j
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_LOCK)
public class RuleLockLogicFilter implements ILogicFilter<RuleActionEntity.RaffleCenterEntity> {

    @Resource
    private IStrategyRepository strategyRepository;

    private Long userRaffleCount = 0L;

    @Override
    public RuleActionEntity<RuleActionEntity.RaffleCenterEntity> filter(RuleMatterEntity ruleMatterEntity) {

        log.info("规则过滤-次数锁 userId:{} strategyId:{} ruleModel:{}", ruleMatterEntity.getUserId(),
                ruleMatterEntity.getStrategyId(), ruleMatterEntity.getRuleModel());

        String ruleValue = strategyRepository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(),
                ruleMatterEntity.getAwardId(),
                ruleMatterEntity.getRuleModel());
        long raffleCount = Long.parseLong(ruleValue);
        if (userRaffleCount >= raffleCount)
            return RuleActionEntity.<RuleActionEntity.RaffleCenterEntity>builder()
                    .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                    .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                    .build();

        return RuleActionEntity.<RuleActionEntity.RaffleCenterEntity>builder()
                .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                .build();

    }
}
