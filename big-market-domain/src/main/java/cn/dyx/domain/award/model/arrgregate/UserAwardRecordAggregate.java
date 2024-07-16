package cn.dyx.domain.award.model.arrgregate;

import cn.dyx.domain.award.model.entity.TaskEntity;
import cn.dyx.domain.award.model.entity.UserAwardRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyx
 * @description ...
 * @create 2024/7/16 9:35
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAwardRecordAggregate {
    private TaskEntity taskEntity;
    private UserAwardRecordEntity userAwardRecordEntity;
}
