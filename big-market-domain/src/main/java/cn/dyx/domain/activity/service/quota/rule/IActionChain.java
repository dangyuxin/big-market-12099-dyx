package cn.dyx.domain.activity.service.quota.rule;

import cn.dyx.domain.activity.model.entity.ActivityCountEntity;
import cn.dyx.domain.activity.model.entity.ActivityEntity;
import cn.dyx.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author dyx
 * @description 下单规则过滤接口
 * @create 2024/7/12 21:55
 */
public interface IActionChain extends IActionChainArmory {

    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}

