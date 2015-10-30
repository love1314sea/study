package 反射;
/*
数组也是对象，java.lang.reflect.Array中的方法可以生成数组,这个类中都是静态方法

 */
import java.lang.reflect.Array;

public class _05_反射中的Array类生成一维数组 {
    public static void main(String[] args) throws Exception {
     //    Class<?> classType = Class.forName("java.lang.String");
    //    Object array = Array.newInstance(classType, 10);

        Object array = Array.newInstance(String.class, 10); //生成String类型，长度为10的数组
        Array.set(array,3,"hello");
        System.out.println((String)Array.get(array,3));
    }
}
