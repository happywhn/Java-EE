package com.itheima.jdbc;

import java.util.List;

public interface AccountDao {
    // 添加
    public int addAccount(Account account);
    // 更新
    public int updateAccount(Account account);
    //删除
    public int deleteAccount(int id);
    public Account findAccountById(int id);
    public List<Account> findAllAccount();
}
