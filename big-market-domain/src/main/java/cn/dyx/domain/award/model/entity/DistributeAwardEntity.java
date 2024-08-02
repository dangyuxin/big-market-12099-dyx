package cn.dyx.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author dyx
 * @description 分发奖品实体
 * @create 2024/8/2 上午9:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributeAwardEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 奖品ID
     */
    private Integer awardId;
    /**
     * 奖品配置信息
     */
    private String awardConfig;

}

