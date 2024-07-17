package cn.dyx.domain.activity.service.armory;

/**
 * @author dyx
 * @description 活动装配预热
 * @create 2024/7/13 15:17
 */
public interface IActivityArmory {

    boolean assembleActivitySku(Long sku);

    boolean assembleActivitySkuByActivityId(Long activityId);
}
