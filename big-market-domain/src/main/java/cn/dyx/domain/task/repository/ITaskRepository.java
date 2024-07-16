package cn.dyx.domain.task.repository;

import cn.dyx.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @author dyx
 * @description 任务服务仓储接口
 * @create 2024/7/16 10:49
 */
public interface ITaskRepository {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);

}

