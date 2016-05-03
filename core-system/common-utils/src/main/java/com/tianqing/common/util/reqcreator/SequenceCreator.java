package com.tianqing.common.util.reqcreator;

import com.tianqing.common.emun.AppType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 根据模块产生请求流水
 * Created by hyb on 2016/4/26.
 */
public class SequenceCreator {

    private static String DATE_FORMATE_PATTERN="yyyyMMddHHmmssSSS";

    private static ThreadLocal<SimpleDateFormat> sdf=new ThreadLocal(){

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMATE_PATTERN);
        }

    };

    public static String createRequestSeq(AppType type){
        int randomNum=ThreadLocalRandom.current().nextInt(type.getValue()*10,10);
        return sdf.get().format(new Date())+Integer.toString(randomNum);
    }

}
