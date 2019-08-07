package com.miyako.subject.commons.utils;

import java.security.MessageDigest;

/**
 * ClassName MD5Util
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 20:43
 */
public class MD5Util{

    private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * MD5加密
     * @param origin 字符
     * @param charsetname 编码
     * @return
     */
    public static String MD5Encode(String origin, String charsetname){
        String result = null;
        if(null == charsetname || "".equals(charsetname)){
            result = MD5Encode(origin);
        }else{
            try{
                result = new String(origin);
                MessageDigest md = MessageDigest.getInstance("MD5");
                result = byteArrayToHexString(md.digest(result.getBytes(charsetname)));
            }catch (Exception e){
            }
        }
        return result;
    }

    public static String MD5Encode(String origin){
        String result = null;
        try{
            result = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byteArrayToHexString(md.digest(result.getBytes()));
        }catch (Exception e){
        }
        return result;
    }


    public static String byteArrayToHexString(byte bytes[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++){
            resultSb.append(byteToHexString(bytes[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte _byte){
        int n = _byte;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
}
