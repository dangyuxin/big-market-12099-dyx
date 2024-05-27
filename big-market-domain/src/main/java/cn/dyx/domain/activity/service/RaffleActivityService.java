package cn.dyx.domain.activity.service;

import cn.dyx.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @author dyx
 * @description 抽奖活动服务
 * @create 2024/5/27 22:56
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity {

    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }

}
