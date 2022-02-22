package com.itheima.po;

import java.util.List;

/**
 * 订单持久化类，用于多对多测试
 *
 * @author whn
 */
public class Orders {
    /**
     * 订单 id
     */
    private Integer id;
    /**
     * 订单编号
     */
    private String number;
    /**
     * 关联商品集合信息
     */
    private List<Product> productList;

    public Orders() {
    }

    public Orders(Integer id, String number, List<Product> productList) {
        this.id = id;
        this.number = number;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", productList=" + productList +
                '}';
    }
}
