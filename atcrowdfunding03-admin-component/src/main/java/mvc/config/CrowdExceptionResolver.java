package mvc.config;


import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import util.CrowdUtil;
import util.ResultEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@ControllerAdvice表示当前类是一个基于注解的异常处理器类
@ControllerAdvice
public class CrowdExceptionResolver {

    //@ExceptionHandler将一个具体的异常类和一个方法映射
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = "system_error";
        return commonResolve(viewName,exception,request,response);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView resolveArithmeticException(ArithmeticException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = "system_error";
        return commonResolve(viewName,exception,request,response);
    }


    private ModelAndView commonResolve(String viewName, Exception exception,HttpServletRequest request , HttpServletResponse response) throws IOException {
        //1.判断请求类型
        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        //2.ajax请求
        if(judgeResult){
            //3.创建ResultEntity对象
            ResultEntity<Object> resultEntity = ResultEntity.failedWithMessage(exception.getMessage());
            //4.创建Gson对象
            Gson gson = new Gson();
            //5.将ResultEntity转换成Json字符串
            String json = gson.toJson(resultEntity);
            //6.将Json字符串作为响应体返回给浏览器
            response.getWriter().write(json);

            //7.由于上述步骤通过原生的response对象返回了响应，所以不提供ModelAndView对象
            return null;
        }
        //8.如果不是Ajax请求则创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        //9.将Exception对象存入模型
        modelAndView.addObject("Exception",exception);

        //10.设置对应的视图
        modelAndView.setViewName(viewName);

        return modelAndView;
    }

}
