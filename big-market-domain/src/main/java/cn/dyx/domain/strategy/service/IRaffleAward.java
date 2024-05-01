package cn.dyx.domain.strategy.service;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @author dyx
 * @description 策略奖品接口
 * @create 2024/5/1 16:44
 */
public interface IRaffleAward {
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);

}
