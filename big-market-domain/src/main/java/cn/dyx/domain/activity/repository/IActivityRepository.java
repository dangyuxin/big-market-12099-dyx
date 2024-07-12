package cn.dyx.domain.activity.repository;


import cn.dyx.domain.activity.model.arrgregate.CreateOrderAggregate;
import cn.dyx.domain.activity.model.entity.ActivityCountEntity;
import cn.dyx.domain.activity.model.entity.ActivityEntity;
import cn.dyx.domain.activity.model.entity.ActivitySkuEntity;


/**
 * @author dyx
 * @description 活动仓储接口
 * @create 2024/5/27 22:49
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void doSaveOrder(CreateOrderAggregate createOrderAggregate);
}

