package 日期时间;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by wushang on 15/11/18.
 */
public class _00_不同时区转换 {
    public static void main(String[] args) throws ParseException {
        Date d=new Date();
        DateFormat format=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");

        System.out.println(format.format(d));  //星期三, 18 十一月 2015 15:18:46 CST   //默认本地时区 ,比GMT快8个小时

        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(format.format(d)); // 星期三, 18 十一月 2015 07:18:46 GMT

        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(format.format(d)); // 星期三, 18 十一月 2015 07:18:46 GMT

    }
}
