package com.itheima.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao")
//相当与配置文件的<bean id="userDao" class="com....UserDaoImpl"/>
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("userdao...save...");
    }
}
