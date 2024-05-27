package cn.dyx.domain.activity.model.arrgregate;

import cn.dyx.domain.activity.model.entity.ActivityAccountEntity;
import cn.dyx.domain.activity.model.entity.ActivityOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyx
 * @description 下单聚合对象
 * @create 2024/5/27 22:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderAggregate {

    /**
     * 活动账户实体
     */
    private ActivityAccountEntity activityAccountEntity;
    /**
     * 活动订单实体
     */
    private ActivityOrderEntity activityOrderEntity;

}

