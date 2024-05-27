package cn.dyx.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dyx
 * @description 活动状态值对象
 * @create 2024/5/27 22:48
 */
@Getter
@AllArgsConstructor
public enum ActivityStateVO {

    create("create", "创建");

    private final String code;
    private final String desc;

}

