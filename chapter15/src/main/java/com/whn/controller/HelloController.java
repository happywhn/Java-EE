package com.whn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/14 11:56
 */
@Controller
public class HelloController {
    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/hello")
    public String Hello() {
        System.out.println("Hello");
        return "success";
    }
}
