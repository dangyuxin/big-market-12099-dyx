package cn.dyx.infrastructure.persistent.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dyx
 * @description 用户积分账户表 持久化对象
 * @create 2024/8/2 上午9:26
 */
@Data
public class UserCreditAccount {
    // 自增id
    private Long id;
    // 用户id
    private String userId;
    // 总积分，显示总账户值，记录一个人的总积分
    private BigDecimal totalAmount;
    // 可用积分，每次扣减的值
    private BigDecimal availableAmount;
    // 用户状态 【open-可用，close-冻结】
    private String accountStatus;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
}
