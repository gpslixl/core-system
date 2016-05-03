package com.tianqing.common.emun;

import lombok.Getter;

/**
 * 模块类型
 * Created by hyb on 2016/4/26.
 */
public enum AppType {

    CORE_SERVICE(0,"核心业务模块"),
    GPS_SERVICE(1,"GPS收发模块"),
    FORM_SERVICE(2,"统计报表模块"),
    OPER_SERVICE(3,"客户运营模块");

    @Getter
    private int value;

    @Getter
    private String name;

    private AppType(int value,String name){
        this.value=value;
        this.name=name;
    }

    /**
     * 获得值对应的规则枚举
     * @param value 标识值
     * @return
     */
    public static AppType getEnum(int value){
        AppType[] types=AppType.values();
        for(AppType type : types){
            if(type.value==value){
                return type;
            }
        }
        return null;
    }

}
