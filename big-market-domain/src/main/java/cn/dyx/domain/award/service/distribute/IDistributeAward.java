package cn.dyx.domain.award.service.distribute;

import cn.dyx.domain.award.model.entity.DistributeAwardEntity;

/**
 * @author dyx
 * @description 分发奖品接口
 * @create 2024/8/2 上午9:46
 */
public interface IDistributeAward {

    void giveOutPrizes(DistributeAwardEntity distributeAwardEntity);

}

