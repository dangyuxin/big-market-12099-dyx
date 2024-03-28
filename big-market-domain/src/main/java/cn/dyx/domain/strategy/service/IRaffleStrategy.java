package cn.dyx.domain.strategy.service;

import cn.dyx.domain.strategy.model.entity.RaffleAwardEntity;
import cn.dyx.domain.strategy.model.entity.RaffleFactorEntity;

public interface IRaffleStrategy {
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
