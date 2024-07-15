package cn.dyx.domain.activity.service.quota.rule;

/**
 * @author dyx
 * @description 下单规则责任链抽象类
 * @create 2024/7/12 21:56
 */
public abstract class AbstractActionChain implements IActionChain {

    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

}
