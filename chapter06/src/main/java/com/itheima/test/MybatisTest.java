package com.itheima.test;

import com.itheima.po.Customer;
import com.itheima.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 根据客户编号查询客户信息
     */
    @Test
    public void findCustomerByIdTest() throws IOException {
        // 1.读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream=
                Resources.getResourceAsStream(resource);
        // 2.根据配置文件构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3.通过 SqlSessionFactory 创建 SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        // 4.SqlSession 执行映射文件中定义的 SQL，并返回结果
        Customer customer=sqlSession.selectOne("com.itheima.mapper.CustomerMapper.findCustomerById",1);
        // 打印输出结果
        System.out.println(customer.toString());
        // 5.关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void findCustomerByNameTest() throws IOException {
        String resource ="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        // 2. 根据配置文件构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 通过 SqlSessionFactory 创建 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4. SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        List<Customer> customers =sqlSession.selectList("com.itheima.mapper.CustomerMapper." +
                "findCustomerByName","j");
        for (Customer customer:customers){
            // 打印输出结果集
            System.out.println(customer);
        }
        // 5. 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 添加客户
     */
    @Test
    public void addCustomerTest() throws IOException {
        String resource ="mybatis-config.xml";
        InputStream inputStream=Resources.getResourceAsStream(resource);
        // 2. 根据配置文件构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 通过 SqlSessionFactory 创建 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = new Customer(10,"无语","家里蹲","123");
        // 4. SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        int rows =sqlSession.insert("com.itheima.mapper.CustomerMapper." +
                "addCustomer",customer);
        if(rows > 0)
            System.out.println("成功插入"+rows+"条数据");
        else
            System.out.println("执行插入操作失败!!!");
        // 5 提交事务
        sqlSession.commit();
        // 6. 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findAllUserTest() {
        // 获取 SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession 执行映射文件中定义的 SQL，并返回映射结果
        List<User> list=
                sqlSession.selectList("com.itheima.mapper.UserMapper.findAllUser");
        for (User user:list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
