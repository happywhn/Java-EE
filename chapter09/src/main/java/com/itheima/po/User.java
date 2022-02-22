package com.itheima.po;

import java.util.List;

/**
 * 用户持久化类
 *
 * @author whn
 */
public class User {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 用户关联的订单
     */
    private List<Order> orderList;

    public User() {
    }

    public User(Integer id, String username, String address, List<Order> orderList) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.orderList = orderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
