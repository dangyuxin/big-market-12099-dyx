package cn.dyx.domain.award.repository;

import cn.dyx.domain.award.model.arrgregate.UserAwardRecordAggregate;

/**
 * @author dyx
 * @description ...
 * @create 2024/7/16 9:35
 */
public interface IAwardRepository {
     void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);
}
