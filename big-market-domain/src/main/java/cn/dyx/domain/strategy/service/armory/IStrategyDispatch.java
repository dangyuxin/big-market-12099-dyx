package cn.dyx.domain.strategy.service.armory;

import java.util.Date;

public interface IStrategyDispatch {
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(String key);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     * @param strategyId  策略ID
     * @param awardId     奖品ID
     * @param endDateTime 活动结束时间
     * @return 扣减结果
     */
    boolean subtractionAwardStock(Long strategyId, Integer awardId, Date endDateTime);

}
