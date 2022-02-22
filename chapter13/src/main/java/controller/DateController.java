package controller;

import org.springframework.format.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/12 12:51
 * 日期控制类
 */
@Controller
public class DateController {
    /**
     * 使用自定义类型数据绑定日期数据
     * @param date
     * @return
     */
    @RequestMapping("/customDate")
    public String CustomDate(Date date) {
        System.out.println("date="+date);
        return "success";
    }

}
