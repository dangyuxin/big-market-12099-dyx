package cn.dyx.test.infrastructure;

import cn.dyx.domain.strategy.model.vo.RuleTreeVO;
import cn.dyx.domain.strategy.repositoty.IStrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author dyx
 * @description 仓储数据查询
 * @create 2024/4/19 15:03
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StratgegyRepositoryTest {

    @Resource
    private IStrategyRepository strategyRepository;

    @Test
    public void test1() {
        RuleTreeVO ruleTreeVO = strategyRepository.queryRuleTreeVOByTreeId("tree_lock");
        log.info("测试结果 --> {}", ruleTreeVO);
    }

}
