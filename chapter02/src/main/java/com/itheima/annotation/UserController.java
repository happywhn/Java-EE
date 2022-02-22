package com.itheima.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")
//相当于配置文件中<bean id="userController" class="com...UserController"/>
public class UserController {
    @Resource(name = "userService")
    //相当与配置文件中<property name="userService" ref="userService"/>
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        this.userService.save();
        System.out.println("userController...save...");
    }
}
