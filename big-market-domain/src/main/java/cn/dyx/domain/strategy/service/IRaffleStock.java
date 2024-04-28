package cn.dyx.domain.strategy.service;

import cn.dyx.domain.strategy.model.vo.StrategyAwardStockKeyVO;

/**
 * @author dyx
 * @description 获取库存消耗队列
 * @create 2024/4/28 21:44
 */
public interface IRaffleStock {
    /**
     * 获取奖品库存消耗队列
     *
     * @return 奖品库存Key信息
     * @throws InterruptedException 异常
     */
    StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException;

    /**
     * 更新奖品库存消耗记录
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     */
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

}
