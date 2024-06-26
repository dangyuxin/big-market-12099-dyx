package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dyx
 * @description 抽奖活动次数配置表Dao
 * @create 2024/5/25 18:43
 */
@Mapper
public interface IRaffleActivityCountDao {
    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);
}
