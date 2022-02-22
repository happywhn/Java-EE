package com.itheima.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    /**
     * 使用execute()方法建表
     * @param args
     */
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取JdbcTemplate实例
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        // 使用 execute() 方法执行 SQL 语句，创建用户账户管理表 account
        String sql="create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double)";
        jdbcTemplate.execute(sql);
        System.out.println("账户表 account 创建成功！");
    }
}
