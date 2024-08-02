package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.UserCreditAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dyx
 * @description 用户积分账户
 * @create 2024/8/2 上午9:33
 */
@Mapper
public interface IUserCreditAccountDao {

    void insert(UserCreditAccount userCreditAccountReq);

    int updateAddAmount(UserCreditAccount userCreditAccountReq);

}

