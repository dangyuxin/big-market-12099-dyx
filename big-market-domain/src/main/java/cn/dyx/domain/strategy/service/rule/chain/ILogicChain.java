package cn.dyx.domain.strategy.service.rule.chain;

/**
 * @author dyx
 * @description 责任链接口
 * @create 2024/4/11 19:54
 */
public interface ILogicChain extends ILogicChainArmory{

    /**
     *
     * @param userId 用户id
     * @param strategyId 策略id
     * @return 奖品id
     */
    Integer logic (String userId,Long strategyId);
}
