import com.tianqing.common.emun.AppType;
import com.tianqing.common.util.reqcreator.SequenceCreator;
import org.junit.Assert;
import org.junit.Test;

/**
 * 序列生成工具测试类
 * Created by hyb on 2016/4/26.
 */
public class SequenceCreatorTest {

    @Test
    public void createRequestSeqTest(){
        String seq=SequenceCreator.createRequestSeq(AppType.CORE_SERVICE);
        Assert.assertNotNull(seq);
        System.out.println(seq);
    }

}
