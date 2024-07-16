package cn.dyx.domain.task.model.entity;

import lombok.Data;

/**
 * @author dyx
 * @description 任务实体对象
 * @create 2024/7/16 10:49
 */
@Data
public class TaskEntity {

    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;

}

