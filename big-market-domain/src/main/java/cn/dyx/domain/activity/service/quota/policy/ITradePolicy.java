package cn.dyx.domain.activity.service.quota.policy;

import cn.dyx.domain.activity.model.arrgregate.CreateQuotaOrderAggregate;

/**
 * @author dyx
 * @description 交易策略接口，包括；返利兑换（不用支付），积分订单（需要支付）
 * @create 2024/8/5 下午3:26
 */

public interface ITradePolicy {

    void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate);

}