package cn.dyx.trigger.api.dto;

import lombok.Data;

/**
 * @author dyx
 * @description 抽奖奖品列表, 请求对象
 * @create 2024/5/1 16:27
 */
@Data
public class RaffleAwardListRequestDto {
    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}
