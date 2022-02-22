package com.itheima.po;

/**
 * 订单持久化类，用于一对多测试
 * @author whn
 */
public class Order {
    /**
     * 订单 id
     */
    private Integer id;
    /**
     * 订单编号
     */
    private String number;

    public Order() {
    }

    public Order(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
