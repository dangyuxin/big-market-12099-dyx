package cn.dyx.domain.strategy.service.rule.filter;

import cn.dyx.domain.strategy.model.entity.RuleActionEntity;
import cn.dyx.domain.strategy.model.entity.RuleMatterEntity;

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}