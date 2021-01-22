package util;

import constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 判断当前请求是否为Ajax请求，返回True则为Ajax请求；
 */
public class CrowdUtil {
    public static boolean judgeRequestType(HttpServletRequest request){
        //1.获取请求消息头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Request-With");

        //2.判断
        if((acceptHeader != null && acceptHeader.contains("application/json"))
        ||(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"))){
            return true;
        }
        return false;
    }

    public static String md5(String source){
        if( source == null || source.length() == 0){
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        // 获取MessageDigest对象
        String algorithm = "md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 获取明文字符串对应的字节数组
            byte[] input = source.getBytes();
            //执行加密
            byte[] output = messageDigest.digest(input);
            //创建BigInteger对象
            int signum = 1;// 1表示正数
            BigInteger bigInteger = new BigInteger(signum,output);
            // 按照16进制将bigInteger的值转换为字符串
            int radix = 16;
            String encode = bigInteger.toString(radix);
            return encode;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return  null;
    }






}
