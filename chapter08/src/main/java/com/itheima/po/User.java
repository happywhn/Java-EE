package com.itheima.po;

public class User {
    private Integer t_id;
    private String t_name;
    private Integer t_age;

    public User() {
    }

    public User(Integer t_id, String t_name, Integer t_age) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_age = t_age;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Integer getT_age() {
        return t_age;
    }

    public void setT_age(Integer t_age) {
        this.t_age = t_age;
    }

    @Override
    public String toString() {
        return "User{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_age=" + t_age +
                '}';
    }
}
