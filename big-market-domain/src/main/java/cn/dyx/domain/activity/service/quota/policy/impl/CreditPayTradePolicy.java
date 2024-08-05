package cn.dyx.domain.activity.service.quota.policy.impl;

import cn.dyx.domain.activity.model.arrgregate.CreateQuotaOrderAggregate;
import cn.dyx.domain.activity.model.valobj.OrderStateVO;
import cn.dyx.domain.activity.repository.IActivityRepository;
import cn.dyx.domain.activity.service.quota.policy.ITradePolicy;
import org.springframework.stereotype.Service;

/**
 * @author dyx
 * @description 积分兑换，支付类订单
 * @create 2024/8/5 下午3:26
 */

@Service("credit_pay_trade")
public class CreditPayTradePolicy implements ITradePolicy {

    private final IActivityRepository activityRepository;

    public CreditPayTradePolicy(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate) {
        createQuotaOrderAggregate.setOrderState(OrderStateVO.wait_pay);
        activityRepository.doSaveCreditPayOrder(createQuotaOrderAggregate);
    }

}
