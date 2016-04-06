package 字符串;

import java.io.UnsupportedEncodingException;

/**
 * Created by wushang on 15/10/31.
 */
public class _04_getByte {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "hb过";
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(bytes.length);
        System.out.println(s.getBytes("UTF-16").length);
        System.out.println(s.getBytes().length);

        System.out.println(new String(bytes,"UTF-8"));
    }
}
