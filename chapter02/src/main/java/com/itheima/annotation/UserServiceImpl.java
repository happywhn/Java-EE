package com.itheima.annotation;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service//相当与配置文件中<bean id="userService" class="com....UserServiceImpl"/>

public class UserServiceImpl implements UserService{
    @Resource(name = "userDao")
    //相当于配置文件中<property name="userDao" ref="userDao"/>
    private UserDao userDao;
    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userservice...save...");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
