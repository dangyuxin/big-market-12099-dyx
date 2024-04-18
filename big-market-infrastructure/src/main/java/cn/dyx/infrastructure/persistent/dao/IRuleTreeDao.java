package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author dyx
 * @description 规则树DAO
 * @create 2024/4/18 下午7:39
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}

