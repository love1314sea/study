package IO;

/**
 * Created by wushang on 16/5/29.
 */
public class _01_ {
    public static void main(String[] args) throws Exception{
        String name = "I am 君山";
        System.out.println(name.toCharArray().length);
        System.out.println(name.getBytes("UTF-16").length);
        System.out.println(name.getBytes("GB2312").length);
    }
}
