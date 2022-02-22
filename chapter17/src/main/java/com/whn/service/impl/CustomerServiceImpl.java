package com.whn.service.impl;

import com.whn.dao.CustomerDao;
import com.whn.po.Customer;
import com.whn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/17 21:43
 * @description
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    /**
     * 注解注入CustomerDao
     */
    @Autowired
    private CustomerDao customerDao;
    @Override
    public Customer findCustomerById(Integer id) {
        return this.customerDao.findCustomerById(id);
    }
}
