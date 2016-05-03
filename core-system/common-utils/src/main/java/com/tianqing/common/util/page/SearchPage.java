package com.tianqing.common.util.page;

import lombok.Getter;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 搜索分页
 * Created by hyb on 2016/4/26.
 */
public class SearchPage<T> extends BasePage<T>{

    /**
     * 前页数目
     */
    @Getter
    private Integer preNum=0;

    /**
     * 后页数目
     */
    @Getter
    private Integer afterNum=0;

    /**
     * 是否有上一页
     */
    @Getter
    private Boolean hasPre=false;

    /**
     * 是否有下一页
     */
    @Getter
    private Boolean hasAfter=false;

    public SearchPage(BasePage<T> page,int wide) throws Exception{
        Integer currentPage=page.getCurrentPage();
        Integer totalNum=page.getTotalNum();
        Integer totalPage=page.getTotalPage();
        BeanUtils.copyProperties(this,page);
        if(currentPage!=null && totalNum!=null && totalPage!=null && wide>0){
            if(currentPage>1){
                this.hasPre=true;
                this.preNum=currentPage>wide?wide:currentPage-1;
            }
            if(totalPage-currentPage>0){
                this.hasAfter=true;
                this.afterNum=totalPage-currentPage>wide?wide:totalPage-currentPage;
            }
        }
    }

}
