package com.example.learning_system.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.learning_system.pojo.Result;
import com.example.learning_system.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*") //拦截所有请求
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将servletRequest、servletResponse转化为HttpservletRequest、HttpservletResponse
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取请求的url
        String url = req.getRequestURL().toString();
        //判断url中是否包含login
        if(url.contains("login")){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //获取请求头中的令牌
        String token = req.getHeader("token");

        //并且判断令牌是否存在,若为空则返回错误响应
        if(!StringUtils.hasLength(token)){
            Result error = Result.error("NOT_LOGIN");
            //将Result对象转为json格式---阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            //respon结果返回给浏览器
            resp.getWriter().write(notLogin);
            return;
        }
        //token存在，需要校验令牌
        try {
            //解析JWT令牌
            JwtUtils.parseJWT(token);
        }
        catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            //将Result对象转为json格式---阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            //respon结果返回给浏览器
            resp.getWriter().write(notLogin);
            return;
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
