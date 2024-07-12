package cn.dyx.domain.activity.service.rule.impl;

import cn.dyx.domain.activity.model.entity.ActivityCountEntity;
import cn.dyx.domain.activity.model.entity.ActivityEntity;
import cn.dyx.domain.activity.model.entity.ActivitySkuEntity;
import cn.dyx.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dyx
 * @description 商品库存规则节点
 * @create 2024/7/12 22:01
 */
@Slf4j
@Component("activity_sku_stock_action")
public class ActivitySkuStockActionChain extends AbstractActionChain {

    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-商品库存处理【校验&扣减】开始。");

        return true;
    }

}
