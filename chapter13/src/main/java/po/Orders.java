package po;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/11 22:31
 * 订单 POJO
 */
public class Orders {
    /**
     * 订单编号
     */
    private Integer ordersId;
    /**
     * 用户 POJO，所属用户
     */
    private User user;

    public Orders() {
    }

    public Orders(Integer ordersId, User user) {
        this.ordersId = ordersId;
        this.user = user;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + ordersId +
                ", user=" + user +
                '}';
    }


}
