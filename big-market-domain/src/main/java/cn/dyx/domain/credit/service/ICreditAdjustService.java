package cn.dyx.domain.credit.service;

import cn.dyx.domain.credit.model.entity.TradeEntity;

/**
 * @author dyx
 * @description 积分调额接口【正逆向，增减积分】
 * @create 2024/8/2 下午4:09
 */
public interface ICreditAdjustService {

    /**
     * 创建增加积分额度订单
     *
     * @param tradeEntity 交易实体对象
     * @return 单号
     */
    String createOrder(TradeEntity tradeEntity);

}
