package com.tianqing.common.emun;

import lombok.Getter;

/**
 * 核心模块对外响应编码
 * Created by hyb on 2016/4/26.
 */
public enum CoreOutRes {

    SUCCESS("CORE000000","成功"),
    FAIL("CORE000001","失败"),
    TIME_OUT("CORE000002","超时"),
    EXCEPTION("CORE000003","系统异常");

    @Getter
    private String code;

    @Getter
    private String desc;

    private CoreOutRes(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    /**
     * 获得值对应的规则枚举
     * @param code 响应编码
     * @return
     */
    public static CoreOutRes getEnum(String code){
        CoreOutRes[] types=CoreOutRes.values();
        for(CoreOutRes type : types){
            if(type.code==code){
                return type;
            }
        }
        return null;
    }

}
