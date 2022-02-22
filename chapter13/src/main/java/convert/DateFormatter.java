package convert;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author whn
 * @version 1.0
 * @date 2022/2/12 20:20
 * 使用 Formatter 自定义日期转换器
 */
public class DateFormatter implements Formatter<Date> {
    /**
     * 日期格式
     */
    String datePattern = "yyyy-MM-dd HH:mm:ss";
    /**
     * SimpleDateFormat 对象
     */
    private SimpleDateFormat simpleDateFormat;
    @Override
    public String print(Date date, Locale locale) {
        return new SimpleDateFormat().format(date);
    }

    @Override
    public Date parse(String source, Locale locale) throws ParseException {
        simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.parse(source);
    }
}
