package cn.dyx.domain.award.service;

import cn.dyx.domain.award.model.entity.DistributeAwardEntity;
import cn.dyx.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @author dyx
 * @description 奖品服务接口
 * @create 2024/7/16 9:27
 */
public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

    void distributeAward(DistributeAwardEntity distributeAwardEntity);

}

