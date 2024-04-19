package cn.dyx.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author dyx
 * @description 规则树对象
 * @create 2024/4/18 10:06
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleTreeVO {
    private String treeId;
    private String treeName;
    private String treeDesc;
    private String treeRootRuleNode;
    private Map<String, RuleTreeNodeVO> treeNodeMap;
}
