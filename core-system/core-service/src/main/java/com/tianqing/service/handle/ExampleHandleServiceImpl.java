package com.tianqing.service.handle;

import com.tianqing.common.BaseCoreService;
import com.tianqing.common.emun.CoreOutRes;
import com.tianqing.common.entity.core.Student;
import com.tianqing.dao.StudentDao;
import com.tianqing.entity.DB_Student;
import com.tianqing.service.ExampleHandleService;
import com.tianqing.vo.request.ExampleHandleRequest;
import com.tianqing.vo.response.ExampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 示例服务实现类
 * Created by hyb on 2016/4/26.
 */
@Slf4j
@Service
public class ExampleHandleServiceImpl extends BaseCoreService implements ExampleHandleService {

    @Resource
    private StudentDao studentDao;

    @Override
    public ExampleResponse<Student> addNewStudent(ExampleHandleRequest request) {
        Student student=request.getStudent();
        DB_Student db_student=new DB_Student();
        BeanUtils.copyProperties(student,db_student);
        db_student.setReqSeq(request.getReqSeq());
        this.studentDao.save(db_student);
        ExampleResponse<Student> response=new ExampleResponse();
        response.setResponseCode(CoreOutRes.SUCCESS);
        return response;
    }

}
