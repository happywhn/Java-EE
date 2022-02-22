package com.whn.controller;

import com.whn.po.Customer;
import com.whn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/17 21:45
 * @description
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/findCustomerById")
    public String findCustomerById(Integer id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        // 返回客户信息展示页面
        return "customer";
    }
}
