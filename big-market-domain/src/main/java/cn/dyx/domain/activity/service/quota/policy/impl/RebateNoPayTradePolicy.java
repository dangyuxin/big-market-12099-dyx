package cn.dyx.domain.activity.service.quota.policy.impl;

import cn.dyx.domain.activity.model.arrgregate.CreateQuotaOrderAggregate;
import cn.dyx.domain.activity.model.valobj.OrderStateVO;
import cn.dyx.domain.activity.repository.IActivityRepository;
import cn.dyx.domain.activity.service.quota.policy.ITradePolicy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author dyx
 * @description 返利无支付交易订单，直接充值到账
 * @create 2024/8/5 下午3:27
 */

@Service("rebate_no_pay_trade")
public class RebateNoPayTradePolicy implements ITradePolicy {

    private final IActivityRepository activityRepository;

    public RebateNoPayTradePolicy(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate) {
        // 不需要支付则修改订单金额为0，状态为完成，直接给用户账户充值
        createQuotaOrderAggregate.setOrderState(OrderStateVO.completed);
        createQuotaOrderAggregate.getActivityOrderEntity().setPayAmount(BigDecimal.ZERO);
        activityRepository.doSaveNoPayOrder(createQuotaOrderAggregate);
    }

}

