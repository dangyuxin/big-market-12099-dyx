package cn.dyx.domain.strategy.service.rule.chain;

/**
 * @author dyx
 * @description ...
 * @create 2024/4/11 22:16
 */
public interface ILogicChainArmory {
    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);
}
