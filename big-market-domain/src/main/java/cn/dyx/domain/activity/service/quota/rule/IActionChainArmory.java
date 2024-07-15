package cn.dyx.domain.activity.service.quota.rule;

/**
 * @author dyx
 * @description ...
 * @create 2024/7/12 21:55
 */
public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}

