package base;

import com.tianqing.entity.DB_Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试模拟类
 * Created by hyb on 2016/4/13.
 */
public class TestMock {

    public static List<DB_Student> mockQueryStudentListSuc(){
        List<DB_Student> students=new ArrayList();
        students.add(new DB_Student());
        students.add(new DB_Student());
        return students;
    }

}
