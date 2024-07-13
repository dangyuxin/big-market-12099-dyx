package cn.dyx.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyx
 * @description 活动sku库存，key 值对象
 * @create 2024/7/13 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivitySkuStockKeyVO {
    private Long sku;
    private Long activityId;
}
