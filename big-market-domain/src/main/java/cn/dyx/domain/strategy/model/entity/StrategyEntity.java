package cn.dyx.domain.strategy.model.entity;

import cn.dyx.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyEntity {
    /**
     * 抽奖策略ID
     */
    private String strategyId;
    /**
     * 抽奖策略描述
     */
    private String strategyDesc;
    /**
     * 抽奖策略规则
     */
    private String ruleModels;

    public String[] ruleModels() {
        if (StringUtils.isBlank(ruleModels))
            return null;
        return ruleModels.split(Constants.SPLIT);
    }

    public String getWeight() {
        String[] ruledModels = ruleModels();
        for (String ruledModel : ruledModels) {
            if ("rule_weight".equals(ruledModel))
                return ruledModel;
        }
        return null;
    }
}
