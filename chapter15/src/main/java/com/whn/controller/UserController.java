package com.whn.controller;

import com.whn.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/15 16:29
 * @description  向用户登录页面跳转
 */
@Controller
public class UserController {
    /**
     * 向用户登录页面跳转
     */
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        // 获取用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        // 此处模拟从数据库获取用户名和密码后进行判断
        if (username != null && "jack".equals(username)
                && password != null && "123456".equals(password)) {
            // 向用户对象添加到Session
            session.setAttribute("USER_SESSION",user);
            // 重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录");
        return "login";
    }
    /**
     * 向用户页面跳转
     */
    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }
    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除 Session
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:login";
    }
}
