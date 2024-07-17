package cn.dyx.trigger.api;


import cn.dyx.trigger.api.dto.RaffleAwardListRequestDto;
import cn.dyx.trigger.api.dto.RaffleAwardListResponseDto;
import cn.dyx.trigger.api.dto.RaffleStrategyRequestDto;
import cn.dyx.trigger.api.dto.RaffleStrategyResponseDto;
import cn.dyx.types.model.Response;

import java.util.List;

/**
 * @author dyx
 * @description 抽奖服务接口
 * @create 2024/5/1 16:22
 */
public interface IRaffleStrategyService {

    /**
     * 策略装配接口
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);

    /**
     * 查询抽奖奖品列表配置
     *
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDto>> queryRaffleAwardList(RaffleAwardListRequestDto requestDTO);

    /**
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleStrategyResponseDto> randomRaffle(RaffleStrategyRequestDto requestDTO);


}
