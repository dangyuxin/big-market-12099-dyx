package cn.dyx.test.domain;

import cn.dyx.domain.strategy.model.entity.RaffleAwardEntity;
import cn.dyx.domain.strategy.model.entity.RaffleFactorEntity;
import cn.dyx.domain.strategy.service.IRaffleStrategy;
import cn.dyx.domain.strategy.service.armory.IStrategyArmory;
import cn.dyx.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import com.alibaba.fastjson.JSON;
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
    private IStrategyArmory strategyArmory;

    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;


    @Before
    public void setUp() {
        // 策略装配 100001、100002、100003
        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100001L));
        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100006L));
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4900L);
    }

    @Test
    public void test_performRaffle() {
        RaffleFactorEntity raffleFactorEntity =
                RaffleFactorEntity.builder().userId("dyx").strategyId(100006L).build();
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

}
