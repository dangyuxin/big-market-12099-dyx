package cn.dyx.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyx
 * @description Response
 * @create 2024/5/1 16:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
    private String code;
    private String info;
    private T data;
}
