package com.tianqing.service;

import com.tianqing.common.entity.core.Student;
import com.tianqing.vo.request.ExampleHandleRequest;
import com.tianqing.vo.response.ExampleResponse;

/**
 * 示例处理服务接口
 * Created by hyb on 2016/4/26.
 */
public interface ExampleHandleService {

    public ExampleResponse<Student> addNewStudent(ExampleHandleRequest request);

}