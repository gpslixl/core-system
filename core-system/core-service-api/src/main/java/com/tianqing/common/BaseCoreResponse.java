package com.tianqing.common;

import com.tianqing.common.emun.CoreOutRes;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础响应类
 * Created by hyb on 2016/4/26.
 */
public class BaseCoreResponse<T> {

    /**
     * 请求流水
     */
    @Getter
    @Setter
    private String reqSeq;

    /**
     * 响应结果
     */
    @Getter
    @Setter
    private T result;

    /**
     * 响应编码
     */
    @Getter
    private String code;

    /**
     * 响应描述
     */
    @Getter
    private String desc;

    public final void setResponseCode(CoreOutRes res){
        this.code=res.getCode();
        this.desc=res.getCode();
    }
}
