package com.itheima.test;

import com.itheima.po.Orders;
import com.itheima.po.Person;
import com.itheima.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author whn
 * Mybatis 关联查询测试类
 */
public class MybatisAssociatedTest {
    /**
     * 嵌套查询
     */
    @Test
    public void findPersonByIdTest() {
        SqlSession session = MybatisUtils.getSession();
        Person person = session.selectOne("com.itheima.mapper.PersonMapper.findPersonById", 1);
        System.out.println(person);
        session.close();
    }

    /**
     * 嵌套结果
     */
    @Test
    public void findPersonByIdTest2() {
        SqlSession session = MybatisUtils.getSession();
        Person person = session.selectOne("com.itheima.mapper.PersonMapper.findPersonById2", 1);
        System.out.println(person);
        session.close();
    }

    /**
     * 一对多
     */
    @Test
    public void findUserTest() {
        SqlSession session = MybatisUtils.getSession();
        User user = session.selectOne("com.itheima.mapper." +
                "UserMapper.findUserWithOrders", 1);
        System.out.println(user);
        session.close();
    }

    /**
     * 多对多
     */
    @Test
    public void findOrdersTest() {
        SqlSession session = MybatisUtils.getSession();
        Orders orders = session.selectOne("com.itheima.mapper." +
                "OrdersMapper.findOrderWithProduct", 1);
        System.out.println(orders);
        session.close();
    }

    /**
     * 多对多嵌套结果查询
     */
    @Test
    public void findOrdersTest2() {
        SqlSession session = MybatisUtils.getSession();
        Orders orders = session.selectOne("com.itheima.mapper.OrdersMapper." +
                "findOrdersWithProduct2", 1);
        System.out.println(orders);
        session.close();
    }
}
