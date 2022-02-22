package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/9 19:52
 */
@Controller
@RequestMapping("/hi")
public class HiController {
    @RequestMapping("/hello")
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response, Model model) {
        // 向模型对象中添加数据
        model.addAttribute("msg","hi,what do you want to do");
        // 返回视图界面
        return "hello";
    }
}
