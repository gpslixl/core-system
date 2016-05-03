package com.tianqing.common.util.encrypter;

import sun.misc.BASE64Encoder;

/**
 * 字符串加密工具
 * Created by hyb on 2016/4/12.
 */
public class StringEncrypter {

    private static BASE64Encoder encoder;
    static{
        encoder=new BASE64Encoder();
    }

    public static String encryt(String str){
        return encoder.encode(str.getBytes());
    }

}
