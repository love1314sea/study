package 碎片;

/**
 * Created by wushang on 15/10/19.
 */

class Person {
    static {
        System.out.println("persion");
    }
}
class Boy extends Person {
    static {
        System.out.println("Boy");
    }
}
public class _3 {
    public static void main(String[] args) {
        new Boy();//第一次加载时打印
        new Boy();//不打印
    }
}
