package cn.dyx.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * @author dyx
 * @description 用户积分奖品实体对象
 * @create 2024/8/2 上午9:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreditAwardEntity {

    /** 用户ID */
    private String userId;
    /** 积分值 */
    private BigDecimal creditAmount;

}

