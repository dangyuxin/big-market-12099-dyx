package cn.dyx.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyx
 * @description 规则树节点指向线对象。用于from -> to 节点链路关系
 * @create 2024/4/18 10:12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleTreeNodeLineVO {
    private Integer treeId;
    private String ruleNodeFrom;
    private String ruleNodeTo;
    private RuleLimitTypeVO ruleLimitType;
    private RuleLogicCheckTypeVO ruleLimitValue;
}
