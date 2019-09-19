package com.imooc.soufang.config;

import com.imooc.soufang.security.AuthProvider;
import com.imooc.soufang.security.LoginAuthFailHandler;
import com.imooc.soufang.security.LoginUrlEntryPoint;
import com.imooc.soufang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: yuan
 * @Date: 2018/12/21 13:59
 * @Description: 安全与权限配置
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
    }

    @Bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint() {
        return new LoginUrlEntryPoint("/user/login");   // 默认使用用户的登录入口
    }

    @Bean
    public LoginAuthFailHandler authFailHandler() {
        return new LoginAuthFailHandler(urlEntryPoint());
    }

    /**
     * HTTP权限控制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()    // 对请求做授权
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/images/**","/lib/**").permitAll() // 静态资源
                .antMatchers("/admin/login").permitAll()    // 管理员登录入口
                .antMatchers("/user/login").permitAll()     // 用户登录入口

                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN","USER")

                .and().formLogin()
                    .loginProcessingUrl("/login")       // 配置角色登录处理入口
                    .failureHandler(authFailHandler())  // 登陆失败处理
                .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/logout/page")    // 处理登出是原生的/logout, 跳转页面是/logout/page
                    .deleteCookies("JSESSIONID").invalidateHttpSession(true)    // 登出删除cookie，同时session会话失效
                .and().exceptionHandling().authenticationEntryPoint(urlEntryPoint()).accessDeniedPage("/403");    // 处理异常，拒绝访问就重定向到 403 页面


        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();     // 同源策略

    }

    /**
     * 自定义认证策略
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncaoder().encode("123456"))
                .roles("ADMIN");*/

        auth.authenticationProvider(authProvider()).eraseCredentials(true); // 擦除密码
    }

}
