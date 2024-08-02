package cn.dyx.domain.award.service;

import cn.dyx.domain.award.event.SendAwardMessageEvent;
import cn.dyx.domain.award.model.arrgregate.UserAwardRecordAggregate;
import cn.dyx.domain.award.model.entity.DistributeAwardEntity;
import cn.dyx.domain.award.model.entity.TaskEntity;
import cn.dyx.domain.award.model.entity.UserAwardRecordEntity;
import cn.dyx.domain.award.model.valobj.TaskStateVO;
import cn.dyx.domain.award.repository.IAwardRepository;
import cn.dyx.domain.award.service.distribute.IDistributeAward;
import cn.dyx.types.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author dyx
 * @description 奖品服务
 * @create 2024/7/16 9:34
 */
@Service
@Slf4j
public class AwardService implements IAwardService {

    private final IAwardRepository awardRepository;
    private final SendAwardMessageEvent sendAwardMessageEvent;
    private final Map<String, IDistributeAward> distributeAwardMap;

    public AwardService(IAwardRepository awardRepository, SendAwardMessageEvent sendAwardMessageEvent, Map<String,
            IDistributeAward> distributeAwardMap) {
        this.awardRepository = awardRepository;
        this.sendAwardMessageEvent = sendAwardMessageEvent;
        this.distributeAwardMap = distributeAwardMap;
    }


    @Override
    public void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity) {
        // 构建消息对象
        SendAwardMessageEvent.SendAwardMessage sendAwardMessage = new SendAwardMessageEvent.SendAwardMessage();
        sendAwardMessage.setUserId(userAwardRecordEntity.getUserId());
        sendAwardMessage.setAwardId(userAwardRecordEntity.getAwardId());
        sendAwardMessage.setAwardTitle(userAwardRecordEntity.getAwardTitle());
        sendAwardMessage.setOrderId(userAwardRecordEntity.getOrderId());
        sendAwardMessage.setAwardConfig(userAwardRecordEntity.getAwardConfig());

        BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage> sendAwardMessageEventMessage =
                sendAwardMessageEvent.buildEventMessage(sendAwardMessage);

        // 构建任务对象
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUserId(userAwardRecordEntity.getUserId());
        taskEntity.setTopic(sendAwardMessageEvent.topic());
        taskEntity.setMessageId(sendAwardMessageEventMessage.getId());
        taskEntity.setMessage(sendAwardMessageEventMessage);
        taskEntity.setState(TaskStateVO.create);

        // 构建聚合对象
        UserAwardRecordAggregate userAwardRecordAggregate = UserAwardRecordAggregate.builder()
                .taskEntity(taskEntity)
                .userAwardRecordEntity(userAwardRecordEntity)
                .build();

        // 存储聚合对象 - 一个事务下，用户的中奖记录
        awardRepository.saveUserAwardRecord(userAwardRecordAggregate);
        log.info("中奖记录保存完成 userId:{} orderId:{}", userAwardRecordEntity.getUserId(), userAwardRecordEntity.getOrderId());
    }

    @Override
    public void distributeAward(DistributeAwardEntity distributeAwardEntity) {
        // 奖品Key
        String awardKey = awardRepository.queryAwardKey(distributeAwardEntity.getAwardId());
        if (null == awardKey) {
            log.error("分发奖品，奖品ID不存在。awardKey:{}", awardKey);
            return;
        }

        // 奖品服务
        IDistributeAward distributeAward = distributeAwardMap.get(awardKey);

        if (null == distributeAward) {
            log.error("分发奖品，对应的服务不存在。awardKey:{}", awardKey);
            //throw new RuntimeException("分发奖品，奖品" + awardKey + "对应的服务不存在");
            return;
        }

        // 发放奖品
        distributeAward.giveOutPrizes(distributeAwardEntity);
    }



}

