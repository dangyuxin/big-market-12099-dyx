package cn.dyx.trigger.api.dto;

import lombok.Data;

/**
 * @author dyx
 * @description 活动抽奖请求对象
 * @create 2024/7/17 9:43
 */
@Data
public class ActivityDrawRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}

