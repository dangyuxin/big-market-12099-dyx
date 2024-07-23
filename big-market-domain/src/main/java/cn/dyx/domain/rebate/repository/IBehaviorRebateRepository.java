package cn.dyx.domain.rebate.repository;

import cn.dyx.domain.rebate.model.arrgregate.BehaviorRebateAggregate;
import cn.dyx.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import cn.dyx.domain.rebate.model.valboj.BehaviorTypeVO;
import cn.dyx.domain.rebate.model.valboj.DailyBehaviorRebateVO;

import java.util.List;

/**
 * @author dyx
 * @description ...
 * @create 2024/7/22 20:09
 */
public interface IBehaviorRebateRepository {
    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);
}
