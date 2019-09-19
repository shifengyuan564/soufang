package com.imooc.soufang.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于角色的登录入口控制器
 * Created by 瓦力.
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private static final String API_FREFIX = "/api";
    private static final String API_CODE_403 = "{\"code\": 403}";
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private PathMatcher pathMatcher = new AntPathMatcher();
    private final Map<String, String> authEntryPointMap;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        authEntryPointMap = new HashMap<>();
        authEntryPointMap.put("/user/**", "/user/login");   // 普通用户登录入口映射
        authEntryPointMap.put("/admin/**", "/admin/login"); // 管理员登录入口映射
    }

    /**
     * 根据请求路径，路由规则跳转到指定的页面，父类是默认使用loginFormUrl
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
                                                     AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");

        for (Map.Entry<String, String> authEntry : this.authEntryPointMap.entrySet()) {
            if (this.pathMatcher.match(authEntry.getKey(), uri)) {
                return authEntry.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }

    /**
     * 没有权限的时候，会进入commence方法
     *
     * 如果是/api路径 返回json数据 否则按照一般流程处理
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request,  HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        if (uri.startsWith(API_FREFIX)) {                           // 如果以‘/api’开头
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);   // 403没权限
            response.setContentType(CONTENT_TYPE);                  // json格式返回

            PrintWriter pw = response.getWriter();
            pw.write(API_CODE_403);                                 // 返回json数据
            pw.close();
        } else {
            super.commence(request, response, authException);       // 非'/api'开头，按照一般流程走
        }

    }
}
