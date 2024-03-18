package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.Strategy;
import cn.dyx.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();
}
