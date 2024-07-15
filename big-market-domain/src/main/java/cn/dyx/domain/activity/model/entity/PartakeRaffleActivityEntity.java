package cn.dyx.domain.activity.model.entity;

import lombok.Data;

/**
 * @author dyx
 * @description 参与抽奖活动实体对象
 * @create 2024/7/15 11:41
 */
@Data
public class PartakeRaffleActivityEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}

