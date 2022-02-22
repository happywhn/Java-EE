package po;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/10 22:36
 * 用户 POJO 类
 */
public class User {
    /**
     * 用户 id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private Integer password;

    public User() {
    }

    public User(Integer id, String username, Integer password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
