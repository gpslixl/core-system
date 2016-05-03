package com.tianqing.common.emun;

import lombok.Getter;

/**
 * 规则类型
 * Created by hyb on 2016/4/26.
 */
public enum RuleType {

    ELECTRIC_FENCE(0,"电子围栏"),
    FATIGUE_DRIVING(1,"疲劳驾驶");

    @Getter
    private int value;

    @Getter
    private String name;

    private RuleType(int value,String name){
        this.value=value;
        this.name=name;
    }

    /**
     * 获得值对应的规则枚举
     * @param value 标识值
     * @return
     */
    public static RuleType getEnum(int value){
        RuleType[] types=RuleType.values();
        for(RuleType type : types){
            if(type.value==value){
                return type;
            }
        }
        return null;
    }

}
