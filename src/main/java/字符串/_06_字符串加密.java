package 字符串;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wushang on 15/11/1.
 */
//见：你必须知道的261个java语言问题
public class _06_字符串加密 {
    public static String digestMessage(String str, String digestType){
        String message = "";
        try {
            MessageDigest md = MessageDigest.getInstance(digestType);
            md.update(str.getBytes());
//            message = md.digest()
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return message;
    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
