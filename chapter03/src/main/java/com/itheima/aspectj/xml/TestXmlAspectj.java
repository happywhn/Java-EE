package com.itheima.aspectj.xml;

import com.itheima.jdk.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAspectj {
    public static void main(String[] args) {
        String xmlPath="applicationContext2.xml";
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext(xmlPath);
        // 1 从spring容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        // 2 执行方法
        userDao.addUser();
    }
}
