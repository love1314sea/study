package 字符串;

import java.util.regex.Pattern;

/**
 * Created by wushang on 15/10/31.
 */
public class _01_正则表达式字符串切割 {
    public static void main(String[] args) {
        String s = "org.apache.flume";
        Pattern pattern = Pattern.compile("\\.");
        String[] arr = pattern.split(s);

        for(String value : arr) {
            System.out.println(value);
        }
     }
}
