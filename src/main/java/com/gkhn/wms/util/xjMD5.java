package com.gkhn.wms.util;

 

import java.security.MessageDigest;
public class xjMD5 {
    public final static String StandardMD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法�? MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘�?
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public final static String string2MD5(String s) {
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法�? MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘�?
            //mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest(btInput);
            // 把密文转换成十六进制的字符串形式
            StringBuffer hexValue = new StringBuffer();
    		for (int i = 0; i < md.length; i++){
    			int val = ((int) md[i]) & 0xff;
    			if (val < 16)
    				hexValue.append("0");
    			hexValue.append(Integer.toHexString(val));
    		}
    		return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(xjMD5.StandardMD5("123456"));
        System.out.println(xjMD5.string2MD5("123456"));
        System.out.println(xjMD5.StandardMD5("hcyy"));
        System.out.println(xjMD5.StandardMD5("01234567890123456789"));
        System.out.println(xjMD5.StandardMD5("1234"));
    }
}
