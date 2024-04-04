package cn.dyx.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RaffleFactorEntity {

    private String userId;

    private Integer awardId;

    private Long strategyId;
}
