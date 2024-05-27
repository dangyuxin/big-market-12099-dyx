package cn.dyx.domain.activity.repository;


import cn.dyx.domain.activity.model.entity.ActivityCountEntity;
import cn.dyx.domain.activity.model.entity.ActivityEntity;
import cn.dyx.domain.activity.model.entity.ActivitySkuEntity;
import org.springframework.stereotype.Repository;

/**
 * @author dyx
 * @description 活动仓储接口
 * @create 2024/5/27 22:49
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

}

