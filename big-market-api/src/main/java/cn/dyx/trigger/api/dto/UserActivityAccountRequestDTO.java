package cn.dyx.trigger.api.dto;

import lombok.Data;

/**
 * @author dyx
 * @description 用户活动账户应答对象
 * @create 2024/7/23 下午8:31
 */
@Data
public class UserActivityAccountRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
