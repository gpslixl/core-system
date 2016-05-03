import com.tianqing.common.util.page.BasePage;
import com.tianqing.common.util.page.SearchPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * 分页工具测试类
 * Created by hyb on 2016/4/26.
 */
public class PageUtilTest {

    @Test
    public void SearchPageTest(){
        SearchPage page= null;
        try {
            page = new SearchPage(this.initBasePage(),5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(page);
        System.out.println(page);
    }

    private BasePage initBasePage(){
        BasePage page=new BasePage();
        page.setCurrentPage(3);
        page.setPageSize(10);
        page.setTotalPage(5);
        page.setTotalNum(page.getPageSize()*page.getTotalPage());
        System.out.println(page);
        return page;
    }

}
