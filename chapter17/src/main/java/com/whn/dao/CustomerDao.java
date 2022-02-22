package com.whn.dao;

import com.whn.po.Customer;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/17 21:37
 * @description Customer接口文件
 */
public interface CustomerDao {
    /**
     * 根据客户id查询客户信息
     * @param id
     * @return
     */
    public Customer findCustomerById(Integer id);
}
