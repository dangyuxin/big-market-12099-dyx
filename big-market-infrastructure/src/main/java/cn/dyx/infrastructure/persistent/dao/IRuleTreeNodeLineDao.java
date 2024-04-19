package cn.dyx.infrastructure.persistent.dao;

import cn.dyx.infrastructure.persistent.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author dyx
 * @description 规则树节点连线表DAO
 * @create 2024/4/18 下午7:49
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);

}

