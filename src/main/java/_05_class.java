/**
 * Created by wuguizhu on 2015/2/2.
 */
public class _05_class {
    public static void g(int... args) {
        System.out.println(args.getClass());
        System.out.println(" length=" + args.length);
    }
    public static void g2(Integer... args) {
        System.out.println(args.getClass());
        System.out.println(" length=" + args.length);
    }
    public static void main(String[] args) {
        System.out.println("int[]:" + new int[1].getClass());
        System.out.println("Integer[]:" + new Integer[0].getClass());

        g();//传空
        g(1,2);
        g(new int[]{1,2});//可以传数组
        g(new Integer(1), new Integer(2)); //自动拆箱
        //g(new Integer[]{new Integer(1), new Integer(2)});//Integer[]不会自动拆箱成//int[]
        System.out.println("---------------");
        g2();
        g2(1,2);
      //  g2(new int[] {1,2});//int[] 不会自动装箱为 Integer[]
        g2(new Integer(1), new Integer(2));
        g2(new Integer[]{new Integer(1), new Integer(2)});

    }
}
