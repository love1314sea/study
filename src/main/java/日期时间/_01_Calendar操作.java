package 日期时间;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wushang on 15/11/18.
 */
// http://blog.csdn.net/joyous/article/details/9630893
public class _01_Calendar操作 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        int year = calendar.get(Calendar.YEAR);
        System.out.println("YEAR is = " + String.valueOf(year));

        // 显示月份 (从0开始, 实际显示要加一)
        int month = calendar.get(Calendar.MONTH);
        System.out.println("MONTH is = " + (month + 1));

        // 本月第 N 天
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));



    }
}
