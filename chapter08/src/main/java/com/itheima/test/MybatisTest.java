package com.itheima.test;

import com.itheima.po.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    /**
     * 根据客户姓名和职业组合条件查询客户信息表
     */
    @Test
    public void findCustomerByNameAndJobsTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByNameAndJobs", customer);
        for (Customer customer1 : customers) {
            System.out.println(customer1);
        }
        sqlSession.close();
    }

    /**
     * 通过姓名或工作查找客户的详细信息
     */
    @Test
    public void findCustomerByNameOrJobsTest() {
        SqlSession sqlSession = MybatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper.CustomerMapper.findCustomerByNameOrJobs", customer);
        for (Customer customer1 : customers) {
            System.out.println(customer1);
        }
        sqlSession.close();
    }

    /**
     * 更新客户
     */
    @Test
    public void updateCustomer() {
        // 获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // 创建 Customer 对象，并向对象添加数据
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("123455789");
        // 执行 SqlSession 的更新方法，返回的是 SQL 语句影响的行数
        int rows = sqlSession.update("com.itheima.mapper.CustomerMapper.updateCustomer", customer);
        // 通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("成功修改了" + rows + "条数据");
        } else {
            System.out.println("执行修改操作失败");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭事务
        sqlSession.close();
    }

    /**
     * 根据客户编号批量查询客户信息
     */
    @Test
    public void findCustomerByIdsTest() {
        // 获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // 创建 List 集合，封装查询 id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        // 执行 SqlSession 的查询方法，返回结果集
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper." +
                "CustomerMapper.findCustomerByIds", ids);
        // 输出查询结果信息
        for (Customer customer : customers) {
            // 打印输出结果
            System.out.println(customer);
        }
        // 关闭 SqlSession
        sqlSession.close();
    }

    /**
     * <bind>元素的使用
     */
    @Test
    public void findCustomerByNameTest() {
        // 通过工具类生成 SqlSession 对象
        SqlSession sqlSession=MybatisUtils.getSession();
        // 创建 Customer 对象，封装查询的条件
        Customer customer = new Customer();
        customer.setUsername("j");
        // 执行 SqlSession 的查询方法，返回结果集
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper.CustomerMapper." +
                "findCustomerByName",customer);
        // 输出结果集
        for(Customer customer1:customers){
            System.out.println(customer1);
        }
        // 关闭 SqlSession
        sqlSession.close();
    }
}
