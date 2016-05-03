package com.tianqing.vo.response;

import com.tianqing.common.BaseCoreResponse;
import lombok.Data;

/**
 * 示例响应
 * Created by hyb on 2016/4/26.
 */
@Data
public class ExampleResponse<T> extends BaseCoreResponse<T> {

    private String info;

}
