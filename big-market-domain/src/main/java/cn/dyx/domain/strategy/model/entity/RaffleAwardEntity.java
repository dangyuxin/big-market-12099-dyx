package cn.dyx.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RaffleAwardEntity {

    private Long strategyId;

    private Integer awardId;

    private String awardKey;

    private String awardConfig;

    private String awardDesc;
}
