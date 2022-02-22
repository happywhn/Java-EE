package vo;

import po.User;

import java.util.List;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/12 21:12
 * 用户包装类
 */
public class UserVO {
    private List<User> users;

    public UserVO() {
    }

    public UserVO(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "users=" + users +
                '}';
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
