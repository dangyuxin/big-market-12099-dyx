package cn.dyx.test.domain;

import cn.dyx.domain.strategy.service.rule.chain.ILogicChain;
import cn.dyx.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.dyx.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author dyx
 * @description ...
 * @create 2024/4/11 22:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class LogicChainTest {

    @Resource
    private DefaultChainFactory defaultChainFactory;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;


    @Test
    public void test_LogicChain_rule_blacklist() {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        Integer awardId = logicChain.logic("user001", 100001L);
        log.info("测试结果：{}", awardId);
    }

    @Test
    public void test_LogicChain_rule_weight() {
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4900L);
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        Integer awardId = logicChain.logic("dyx", 100001L);
        log.info("测试结果：{}", awardId);
    }

    @Test
    public void test_LogicChain_rule_default() {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        Integer awardId = logicChain.logic("dyx", 100001L);
        log.info("测试结果：{}", awardId);
    }
}
