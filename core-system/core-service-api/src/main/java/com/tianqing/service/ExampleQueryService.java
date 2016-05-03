package com.tianqing.service;

import com.tianqing.vo.request.ExampleQueryRequest;
import com.tianqing.vo.response.ExampleResponse;

/**
 * 示例查询服务接口
 * Created by hyb on 2016/4/26.
 */
public interface ExampleQueryService {

    public ExampleResponse queryStudentPage(ExampleQueryRequest request);

}
