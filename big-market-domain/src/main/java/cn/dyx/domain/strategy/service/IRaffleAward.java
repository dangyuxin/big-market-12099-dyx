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

    /**
     * 根据策略ID查询抽奖奖品列表配置
     *
     * @param activityId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardListByActivityId(Long activityId);


}
