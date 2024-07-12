package cn.dyx.domain.activity.service.rule.impl;

import cn.dyx.domain.activity.model.entity.ActivityCountEntity;
import cn.dyx.domain.activity.model.entity.ActivityEntity;
import cn.dyx.domain.activity.model.entity.ActivitySkuEntity;
import cn.dyx.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dyx
 * @description 活动规则过滤【日期、状态】
 * @create 2024/7/12 22:01
 */
@Slf4j
@Component("activity_base_action")
public class ActivityBaseActionChain extends AbstractActionChain {

    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {

        log.info("活动责任链-基础信息【有效期、状态】校验开始。");

        return next().action(activitySkuEntity, activityEntity, activityCountEntity);
    }

}

