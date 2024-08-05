package cn.dyx.domain.credit.model.arrgregate;


import cn.dyx.domain.award.model.valobj.TaskStateVO;
import cn.dyx.domain.credit.event.CreditAdjustSuccessMessageEvent;
import cn.dyx.domain.credit.model.entity.CreditAccountEntity;
import cn.dyx.domain.credit.model.entity.CreditOrderEntity;
import cn.dyx.domain.credit.model.entity.TaskEntity;
import cn.dyx.domain.credit.model.valobj.TradeNameVO;
import cn.dyx.domain.credit.model.valobj.TradeTypeVO;
import cn.dyx.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;


/**
 * @author dyx
 * @description 交易聚合对象
 * @create 2024/8/2 下午4:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeAggregate {

    // 用户ID
    private String userId;
    // 积分账户实体
    private CreditAccountEntity creditAccountEntity;
    // 积分订单实体
    private CreditOrderEntity creditOrderEntity;
    // 任务实体 - 补偿 MQ 消息
    private TaskEntity taskEntity;

    public static CreditAccountEntity createCreditAccountEntity(String userId, BigDecimal adjustAmount) {
        return CreditAccountEntity.builder().userId(userId).adjustAmount(adjustAmount).build();
    }

    public static CreditOrderEntity createCreditOrderEntity(String userId, TradeNameVO tradeName,
                                                            TradeTypeVO tradeType, BigDecimal tradeAmount,
                                                            String outBusinessNo) {
        return CreditOrderEntity.builder().userId(userId).orderId(RandomStringUtils.randomNumeric(12)).tradeName(tradeName).tradeType(tradeType).tradeAmount(tradeAmount).outBusinessNo(outBusinessNo).build();
    }

    public static TaskEntity createTaskEntity(String userId, String topic, String messageId,
                                              BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage> message) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUserId(userId);
        taskEntity.setTopic(topic);
        taskEntity.setMessageId(messageId);
        taskEntity.setMessage(message);
        taskEntity.setState(TaskStateVO.create);
        return taskEntity;
    }

}

