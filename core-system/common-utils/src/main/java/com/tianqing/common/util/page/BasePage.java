package com.tianqing.common.util.page;

import lombok.Data;

import java.util.List;

/**
 * 基础分页类
 * Created by hyb on 2016/4/26.
 */
@Data
public class BasePage<T> {

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总记录条数
     */
    private Integer totalNum;

    /**
     * 当前页列表
     */
    private List<T> result;

}
