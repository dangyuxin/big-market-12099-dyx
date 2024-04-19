package cn.dyx.domain.strategy.service.rule.chain;

import cn.dyx.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * @author dyx
 * @description 责任链接口
 * @create 2024/4/11 19:54
 */
public interface ILogicChain extends ILogicChainArmory {

    /**
     * @param userId     用户id
     * @param strategyId 策略id
     * @return 奖品id
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);
}
