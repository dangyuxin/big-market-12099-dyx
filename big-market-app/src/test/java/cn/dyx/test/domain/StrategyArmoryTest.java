package cn.dyx.test.domain;

import cn.dyx.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
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

    @Test
    public void test(){
        strategyArmory.assembleLotteryStrategy(100002L);
    }

    @Test
    public void test2(){
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
        log.info("抽奖结果 --> {}",strategyArmory.getRandomAwardId(100002L));
    }
}
