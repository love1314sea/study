package 字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wushang on 15/10/31.
 */
public class _02_判断数值格式 {
    public static boolean checkNum(String s) {
        if(s == null || s.length() == 0)
            return false;
        for(char c : s.toCharArray()) {
            if(c<'0' || c > '9')
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String num = "1234-";

        //使用正则表达式判断
        Pattern pattern  = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(num);
        if(matcher.matches()) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

        //方法2
        System.out.println(checkNum(num));
    }
}
