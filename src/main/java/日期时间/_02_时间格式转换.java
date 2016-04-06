package 日期时间;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wushang on 15/11/18.
 */
public class _02_时间格式转换 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

        String s = dateFormat.format(date);
        System.out.println(s);

        String s2 = "2015-11-18 15:31:43";
        Date date2 = dateFormat.parse(s2);
        System.out.println(date2);
    }
}
