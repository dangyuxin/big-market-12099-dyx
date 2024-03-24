package cn.dyx.test.domain;

import cn.dyx.domain.strategy.service.armory.IStrategyArmory;
import cn.dyx.domain.strategy.service.armory.IStrategyDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StrategyArmoryTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private IStrategyDispatch strategyDispatch;

    @Before
    public void test1() {
        log.info("测试结果 --> {}", strategyArmory.assembleLotteryStrategy(100001L));
    }


    @Test
    public void test() {
        log.info("抽奖结果 --> {}", strategyDispatch.getRandomAwardId(100001L));
    }


    @Test
    public void test2() {
        log.info("抽奖结果4 --> {}", strategyDispatch.getRandomAwardId(100001L, "4000:102,103,104,105"));
        log.info("抽奖结果 5--> {}", strategyDispatch.getRandomAwardId(100001L, "5000:102,103,104,105,106,107"));
        log.info("抽奖结果 6--> {}", strategyDispatch.getRandomAwardId(100001L, "6000:102,103,104,105,106,107,108,109"));
    }


}
