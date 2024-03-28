package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.StrategyAward;
import cn.dyx.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyRuleDao {
    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRule);

    String queryStrategyRuleValue(StrategyRule strategyRule);
}
