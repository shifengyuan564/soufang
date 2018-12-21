package com.imooc.soufang.controller;

import com.imooc.soufang.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 瓦力.
 */
@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("name", "慕课");
        return "index";
    }

    @GetMapping("/response")
    @ResponseBody
    public ApiResponse response(){
        return ApiResponse.ofMessage(200,"成功了");
    }

    /*shiro无权限时进入*/
    @GetMapping("/error/403")
    public String accessError() {
        return "error/403";
    }

    @GetMapping("/error/404")
    public String notFoundPage() {
        return "error/404";
    }

    @GetMapping("/error/500")
    public String internalError() {
        return "error/500";
    }

    @GetMapping("/logout/page")
    public String logoutPage() {
        return "logout";
    }


}
