import base.BaseTest;
import base.TestMock;
import com.tianqing.common.emun.AppType;
import com.tianqing.common.entity.core.Student;
import com.tianqing.common.util.reqcreator.SequenceCreator;
import com.tianqing.dao.StudentDao;
import com.tianqing.service.ExampleHandleService;
import com.tianqing.vo.request.ExampleHandleRequest;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.Date;

import static org.mockito.Mockito.doReturn;

/**
 * 示例测试类
 * Created by hyb on 2016/4/12.
 */
// 修改事务管理，自动回滚，防止影响下次增删测试
@TransactionConfiguration(
        transactionManager = "transactionManager", defaultRollback=true)
public class StudentTest extends BaseTest {

    @Resource
    private ExampleHandleService exampleHandleService;

    @Resource
    private StudentDao studentDao;

    @Test
    public void exampleHandleTest(){
        System.out.println("project started success!");
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
    }

    @Override
    protected void otherMock() {
        doReturn(TestMock.mockQueryStudentListSuc()).when(studentDao).findAll();
    }

}
