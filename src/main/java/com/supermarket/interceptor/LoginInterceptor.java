package com.supermarket.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    //方法执行后被执行
    //处理异常，清资源，记录日志等等
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }
    //方法执行之后，返回ModelAndView之前被执行
    //设置页面的共用参数等等
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    //进入方法前被执行
    //登录拦截，权限验证等等
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        //判断用户有没有登录
        Object object = request.getSession().getAttribute("employee");
        if(object == null){
            request.getRequestDispatcher("/WEB-INF/page/refresh.jsp").forward(request,response);
        }
        //true放行,false拦截
        return true;
    }
}

