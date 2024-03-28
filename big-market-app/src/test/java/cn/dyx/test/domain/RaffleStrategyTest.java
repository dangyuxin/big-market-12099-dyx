package cn.dyx.test.domain;

import cn.dyx.domain.strategy.model.entity.RaffleAwardEntity;
import cn.dyx.domain.strategy.model.entity.RaffleFactorEntity;
import cn.dyx.domain.strategy.service.IRaffleStrategy;
import cn.dyx.domain.strategy.service.rule.impl.RuleWeightLogicFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author dyx
 * @description ...
 * @create 2024/3/28 20:25
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RaffleStrategyTest {

    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private RuleWeightLogicFilter ruleWeightLogicFilter;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(ruleWeightLogicFilter, "userScore", 7500L);
    }


    @Test
    public void test1() {
        RaffleFactorEntity factorEntity = RaffleFactorEntity.builder()
                .strategyId(100001L)
                .userId("dyx")
                .build();
        log.info("参数因子 --> {}", factorEntity);

        for (int i = 0; i < 10; i++) {
            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(factorEntity);
            log.info("抽奖结果 --> {}", raffleAwardEntity);
        }

    }

    @Test
    public void test2() {
        RaffleFactorEntity factorEntity = RaffleFactorEntity.builder()
                .strategyId(100001L)
                .userId("user001")
                .build();
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(factorEntity);
        log.info("参数因子 --> {}", factorEntity);
        log.info("抽奖结果 --> {}", raffleAwardEntity);
    }


}
