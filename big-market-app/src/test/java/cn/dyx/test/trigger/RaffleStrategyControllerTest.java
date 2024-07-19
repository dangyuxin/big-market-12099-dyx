package cn.dyx.test.trigger;

import cn.dyx.trigger.api.IRaffleStrategyService;
import cn.dyx.trigger.api.dto.RaffleAwardListRequestDto;
import cn.dyx.trigger.api.dto.RaffleAwardListResponseDto;
import cn.dyx.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dyx
 * @description ...
 * @create 2024/7/19 21:36
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyControllerTest {

    @Resource
    private IRaffleStrategyService raffleStrategyService;

    @Test
    public void test_queryRaffleAwardList() {
        RaffleAwardListRequestDto request = new RaffleAwardListRequestDto();
        request.setUserId("dyx");
        request.setActivityId(100301L);
        Response<List<RaffleAwardListResponseDto>> response = raffleStrategyService.queryRaffleAwardList(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

}
