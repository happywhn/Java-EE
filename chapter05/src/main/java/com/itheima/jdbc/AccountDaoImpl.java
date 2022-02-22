package com.itheima.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    // 声明JdbcTemplate 属性及其方法
    private JdbcTemplate jdbcTemplate;

    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AccountDaoImpl() {
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        // 定义SQL
        String sql = "insert into account(username,balance) value(?,?)";
        // 定义数组来存储SQL语句中的参数
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        //执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;
    }

    @Override
    public int updateAccount(Account account) {
        return 0;
    }

    @Override
    public int deleteAccount(int id) {
        return 0;
    }


    @Override
    public Account findAccountById(int id) {
        String sql = "select * from account where id=?";
        //创建一个新的 BeanPropertyRowMapper 对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);
        //将id绑定到SQL语句，并通过 RowMapper 返回一个 Object 类型的单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        //创建一个新的 BeanPropertyRowMapper 对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);
        // 执行静态的SQL查询，并通过RowMapper 返回结果
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 转账
     *
     * @param outUser：汇款人
     * @param inUser：收款人
     * @param money：收款金额
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,
         isolation = Isolation.DEFAULT,readOnly = false)
    public void transfer(String outUser, String inUser, Double money) {
        this.jdbcTemplate.update("update account set balance = balance+? where username=?", money, inUser);
        // 模拟系统运行时的突发性问题
        int i = 1 / 0;
        this.jdbcTemplate.update("update account set balance = balance-? where username=?",money,outUser);
    }
}
