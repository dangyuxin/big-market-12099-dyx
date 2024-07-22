package cn.dyx.domain.rebate.model.valboj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dyx
 * @description 任务状态值对象
 * @create 2024/7/22 20:07
 */
@Getter
@AllArgsConstructor
public enum TaskStateVO {

    create("create", "创建"),
    complete("complete", "发送完成"),
    fail("fail", "发送失败"),
    ;

    private final String code;
    private final String desc;

}
