package cn.dyx.domain.credit.repository;

import cn.dyx.domain.credit.model.arrgregate.TradeAggregate;

/**
 * @author dyx
 * @description 用户积分仓储
 * @create 2024/8/2 下午4:09
 */
public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

}

