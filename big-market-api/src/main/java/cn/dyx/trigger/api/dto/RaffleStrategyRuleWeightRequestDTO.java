package cn.dyx.trigger.api.dto;

import lombok.Data;

/**
 * @author dyx
 * @description 抽奖策略规则，权重配置，查询N次抽奖可解锁奖品范围，请求对象
 * @create 2024/7/25 上午9:33
 */
@Data
public class RaffleStrategyRuleWeightRequestDTO {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}

