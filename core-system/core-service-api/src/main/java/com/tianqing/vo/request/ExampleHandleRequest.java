package com.tianqing.vo.request;

import com.tianqing.common.BaseCoreRequest;
import com.tianqing.common.entity.core.Student;
import lombok.Data;

/**
 * 示例处理请求类
 * Created by hyb on 2016/4/26.
 */
@Data
public class ExampleHandleRequest extends BaseCoreRequest {

    private Student Student;

}
