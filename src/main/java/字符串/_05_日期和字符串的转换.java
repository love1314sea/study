package 字符串;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wushang on 15/10/31.
 */
//使用SimpleDataFormat 中的format 和 parse来完成
public class _05_日期和字符串的转换 {
    public static void main(String[] args ) throws ParseException {
        Date date = new Date();
        System.out.println("date= " + date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date->字符串
        String date_format = sdf.format(date);
        System.out.println(date_format);

        //字符串->Date
        Date date1 = sdf.parse("2015-09-09");
        System.out.println(date1);

    }
}
