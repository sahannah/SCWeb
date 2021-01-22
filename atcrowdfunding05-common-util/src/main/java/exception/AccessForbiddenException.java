package exception;

/**
*
* 表示用户访问受权限保护资源产生的异常
* @Author:zhanghan
* @Date:5:11 下午 2021/1/22
*/
public class AccessForbiddenException extends RuntimeException {


    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
