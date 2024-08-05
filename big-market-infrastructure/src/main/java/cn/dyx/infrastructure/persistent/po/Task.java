package cn.dyx.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author dyx
 * @description 任务表，发送MQ
 * @create 2024/7/15 9:08
 */
@Data
public class Task {

    /**
     * 自增ID
     */
    private String id;
    /**
     * 活动ID
     */
    private String userId;
    /**
     * 消息主题
     */
    private String topic;
    /**
     * 消息编号
     */
    private String messageId;
    /**
     * 消息主体
     */
    private String message;
    /**
     * 任务状态；create-创建、completed-完成、fail-失败
     */
    private String state;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}

