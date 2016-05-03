package com.tianqing.common.util.encrypter;

import sun.misc.BASE64Decoder;

/**
 * 字符串解密工具
 * Created by hyb on 2016/4/12.
 */
public class StringDecrypter {

    private static BASE64Decoder decoder;
    static{
        decoder=new BASE64Decoder();
    }

    public static String decryt(String str) throws Exception{
        byte[] bytes=decoder.decodeBuffer(str);
        return new String(bytes);
    }

}
