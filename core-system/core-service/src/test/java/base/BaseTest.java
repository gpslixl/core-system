package base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 * Created by hyb on 2016/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-test-profile.xml"})
@ActiveProfiles(value = "default")
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    protected abstract void otherMock();

    private final void baseMock(){

    }

    @Before
    public final void iniMock(){
        if(this.getClass().getAnnotation( ActiveProfiles.class).value()[0].equals("mock")){
            MockitoAnnotations.initMocks(this);
            this.baseMock();
            this.otherMock();
        }
    }

}
