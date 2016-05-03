package com.tianqing.dao;

import com.tianqing.common.BaseCoreDao;
import com.tianqing.entity.DB_Student;
import org.springframework.stereotype.Repository;

/**
 * 学生表数据库处理类
 * Created by hyb on 2016/4/26.
 */
@Repository
public class StudentDao extends BaseCoreDao<DB_Student> {

    @Override
    protected Class getEntityClass() {
        return DB_Student.class;
    }

}
