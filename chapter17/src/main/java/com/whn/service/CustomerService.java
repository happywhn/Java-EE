package com.whn.service;

import com.whn.po.Customer;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/17 21:40
 * @description
 */
public interface CustomerService {
    /**
     * 根据客户id查询信息
     * @param id
     * @return
     */
    public Customer findCustomerById(Integer id);
}
