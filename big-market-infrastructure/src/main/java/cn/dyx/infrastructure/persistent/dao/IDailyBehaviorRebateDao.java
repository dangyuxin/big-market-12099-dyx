package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.DailyBehaviorRebate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dyx
 * @description 日常行为返利活动配置
 * @create 2024/7/22 16:17
 */
@Mapper
public interface IDailyBehaviorRebateDao {
    List<DailyBehaviorRebate> queryDailyBehaviorRebateByBehaviorType(String code);
}
