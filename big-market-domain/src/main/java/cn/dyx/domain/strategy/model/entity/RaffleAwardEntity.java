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
    private Integer awardId;
    private String awardConfig;
    private String awardTitle;
    private Integer sort;
}
