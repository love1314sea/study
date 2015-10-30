package 类._02_String类;


public class _02_test {
    public static void main(String[] args) {
        String hello = "Hello";
        String lo = "lo";
        System.out.println(hello == "Hel" + "lo");//true。 两个常量相加，形成一个新的常量，同StringＰool中的地址一样。
                                               //常量相加，在编译器计算，结果也为字面值常量
        System.out.println(hello == "Hel" + lo);//false 注意同上一行的区别。 字符串相加在运行期，因此在堆中生成。
        System.out.println(hello == ("Hel" +lo).intern());
        System.out.println(hello == "Hello");
        System.out.println(Other.hello == hello);


    }
}
class Other{
    static String hello = "Hello";
}