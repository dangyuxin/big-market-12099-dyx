package cn.dyx.domain.award.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dyx
 * @description 账户状态枚举
 * @create 2024/8/2 上午9:59
 */
@Getter
@AllArgsConstructor
public enum AccountStatusVO {

    open("open", "开启"),
    close("close", "冻结"),
    ;

    private final String code;
    private final String desc;

}
