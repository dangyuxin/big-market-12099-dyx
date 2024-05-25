package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dyx
 * @description 抽奖活动表Dao
 * @create 2024/5/25 18:43
 */
@Mapper
public interface IRaffleActivityDao {

    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

}

