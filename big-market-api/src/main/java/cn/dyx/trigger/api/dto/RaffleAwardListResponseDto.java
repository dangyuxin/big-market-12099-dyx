package cn.dyx.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyx
 * @description 抽奖奖品列表,响应对象
 * @create 2024/5/1 16:28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardListResponseDto {
    // 奖品id
    private Integer awardId;
    // 奖品标题
    private String awardTitle;
    // 奖品副标题
    private String awardSubTitle;
    //排序编号
    private Integer sort;

}
