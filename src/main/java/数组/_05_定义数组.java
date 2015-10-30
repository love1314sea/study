package 数组;


import java.util.Arrays;
import java.util.Random;

public class _05_定义数组 {
    public static void main(String[] args) {

        Integer[] a = new Integer[5]; //定义数组

        System.out.println(a.toString()); //注意与下一行的区别
        System.out.println(Arrays.toString(a));
        Random random = new Random(45);
        for(int i=0; i<a.length; ++i)
            a[i] = random.nextInt(500);//autoboxing
        System.out.println(Arrays.toString(a));

        System.out.println("-------------------");

        //也可以使用{}来定义并初始化数组,这种方式比较简单，随时生成
        Integer[] b = new Integer[]{new Integer(1), new Integer(2), 3,};
        Integer[] b2 = {new Integer(1), new Integer(2), 3};
        Test.invoke(new String[]{"hello", "boy", "girl"});
    }
}

class Test {
    public static void invoke(String[] args) {
        for(String s : args) {
            System.out.println(s);
        }
    }
}