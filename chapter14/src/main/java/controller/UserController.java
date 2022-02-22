package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import po.User;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/12 22:50
 */
@Controller
public class UserController {
    /**
     * 接收页面请求的JSON数据，并返回JSON格式结果
     * @param user
     * @return
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(@RequestBody User user) {
        // 打印接收的JSON格式数据
        System.out.println(user);
        // 返回JSON格式的响应
        return user;
    }

    /**
     * 接收RESTful风格的请求，其接收方式为GET
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User selectUser(@PathVariable("id") String id) {
        // 查看数据接收
        System.out.println("id="+id);
        User user = new User();
        // 模拟根据id查询到用户对象数据
        if("1234".equals(id)) {
            System.out.println("tom");
            user.setUsername("tom");
        }
        // 返回JSON格式的数据
        return user;
    }
}
