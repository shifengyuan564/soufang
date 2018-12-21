package com.imooc.soufang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 */

@Controller
public class AdminController {

    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }


    /**
     * 欢迎页
     */
    @GetMapping("/admin/welcome")
    public String welcomePage(Model model) {
        return "admin/welcome";
    }

    /**
     * 管理员登陆
     */
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }
}
