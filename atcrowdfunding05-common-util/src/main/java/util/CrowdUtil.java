package util;

import javax.servlet.http.HttpServletRequest;

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
}
