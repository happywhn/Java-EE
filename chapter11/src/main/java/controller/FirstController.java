package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/7 21:45
 * 控制器类
 */
public class FirstController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        // 创建 ModelAndView 对象
        ModelAndView mav = new ModelAndView();
        // 向模型对象中添加数据
        mav.addObject("msg", "这是我的第一个 Spring MVC 程序");
        // 设置逻辑视图名
        mav.setViewName("/WEB-INF/jsp/first.jsp");
        // 返回 ModelAndView 对象
        return mav;
    }
}
