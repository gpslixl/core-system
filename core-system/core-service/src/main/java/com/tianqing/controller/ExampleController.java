package com.tianqing.controller;

import com.tianqing.common.BaseCoreController;
import com.tianqing.common.emun.AppType;
import com.tianqing.common.entity.core.Student;
import com.tianqing.common.util.reqcreator.SequenceCreator;
import com.tianqing.service.ExampleHandleService;
import com.tianqing.vo.request.ExampleHandleRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 测试用主页controller
 * Created by hyb on 2016/4/11.
 */
@Controller
public class ExampleController extends BaseCoreController {

    @Resource
    private ExampleHandleService exampleHandleService;

    @RequestMapping("/toIndex.do")
    public String toIndex(HttpServletRequest reqeust){
        Student student=new Student();
        student.setName("11111");
        student.setGender("1111");
        student.setAge(10);
        ExampleHandleRequest request=new ExampleHandleRequest();
        request.setStudent(student);
        request.setReqApp(AppType.CORE_SERVICE);
        request.setReqIp("127.0.0.1");
        request.setReqSeq(SequenceCreator.createRequestSeq(AppType.CORE_SERVICE));
        request.setReqTime(new Date());
        this.exampleHandleService.addNewStudent(request);
        return "main";
    }

}
