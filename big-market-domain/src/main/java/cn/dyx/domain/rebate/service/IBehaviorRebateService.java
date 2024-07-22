package cn.dyx.domain.rebate.service;

import cn.dyx.domain.rebate.model.entity.BehaviorEntity;

import java.util.List;

/**
 * @author dyx
 * @description 行为返利服务接口
 * @create 2024/7/22 20:02
 */
public interface IBehaviorRebateService {

    /**
     * 创建行为动作的入账订单
     *
     * @param behaviorEntity 行为实体对象
     * @return 订单ID
     */
    List<String> createOrder(BehaviorEntity behaviorEntity);

}

