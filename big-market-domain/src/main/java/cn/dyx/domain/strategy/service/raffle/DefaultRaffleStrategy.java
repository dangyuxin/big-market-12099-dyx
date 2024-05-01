package cn.dyx.domain.strategy.service.raffle;

import cn.dyx.domain.strategy.model.entity.StrategyAwardEntity;
import cn.dyx.domain.strategy.model.vo.RuleTreeVO;
import cn.dyx.domain.strategy.model.vo.StrategyAwardRuleModelVO;
import cn.dyx.domain.strategy.model.vo.StrategyAwardStockKeyVO;
import cn.dyx.domain.strategy.repositoty.IStrategyRepository;
import cn.dyx.domain.strategy.service.AbstractRaffleStrategy;
import cn.dyx.domain.strategy.service.IRaffleAward;
import cn.dyx.domain.strategy.service.IRaffleStock;
import cn.dyx.domain.strategy.service.armory.IStrategyDispatch;
import cn.dyx.domain.strategy.service.rule.chain.ILogicChain;
import cn.dyx.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.dyx.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import cn.dyx.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author dyx
 * @description 默认抽奖策略
 * @create 2024/3/28 20:06
 */


@Slf4j
@Service
public class DefaultRaffleStrategy extends AbstractRaffleStrategy implements IRaffleAward, IRaffleStock {

    public DefaultRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch,
                                 DefaultChainFactory defaultChainFactory, DefaultTreeFactory defaultTreeFactory) {
        super(repository, strategyDispatch, defaultChainFactory, defaultTreeFactory);
    }

    @Override
    public DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId, Long strategyId) {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);
        return logicChain.logic(userId, strategyId);
    }

    @Override
    public DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId, Long strategyId, Integer awardId) {
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModelVO(strategyId,
                awardId);
        if (null == strategyAwardRuleModelVO) {
            return DefaultTreeFactory.StrategyAwardVO.builder().awardId(awardId).build();
        }
        RuleTreeVO ruleTreeVO = repository.queryRuleTreeVOByTreeId(strategyAwardRuleModelVO.getRuleModels());
        if (null == ruleTreeVO) {
            throw new RuntimeException("存在抽奖策略配置的规则模型 Key，未在库表 rule_tree、rule_tree_node、rule_tree_line 配置对应的规则树信息 " + strategyAwardRuleModelVO.getRuleModels());
        }
        IDecisionTreeEngine treeEngine = defaultTreeFactory.openLogicTree(ruleTreeVO);
        return treeEngine.process(userId, strategyId, awardId);
    }

    @Override
    public StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException {
        return repository.takeQueueValue();
    }

    @Override
    public void updateStrategyAwardStock(Long strategyId, Integer awardId) {
        repository.updateStrategyAwardStock(strategyId, awardId);
    }

    @Override
    public List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId) {
        return repository.queryStrategyAwardList(strategyId);
    }
}
