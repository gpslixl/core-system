package com.tianqing.vo.request;

import com.tianqing.common.BaseCoreRequest;
import com.tianqing.common.util.page.BasePage;
import lombok.Data;

/**
 * 查询学生分页
 * Created by hyb on 2016/4/26.
 */
@Data
public class ExampleQueryRequest extends BaseCoreRequest {

    private BasePage page;

}
