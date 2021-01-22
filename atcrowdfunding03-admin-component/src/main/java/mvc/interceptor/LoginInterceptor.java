package mvc.interceptor;

import constant.CrowdConstant;
import entity.Admin;
import exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Admin admin =(Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);
        if(admin == null){
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDDEN);

        }

        return true;

    }
}
