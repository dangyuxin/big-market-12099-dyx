package cn.dyx.domain.credit.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author dyx
 * @description 交易名称枚举值
 * @create 2024/8/2 下午4:05
 */
@Getter
@AllArgsConstructor
public enum TradeNameVO {

    REBATE("行为返利"),
    CONVERT_SKU("兑换抽奖"),

    ;

    private final String name;

}
