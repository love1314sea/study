package 反射;
/*
为什么有反射：java程序可以加载一个运行时才知类名的class（在运行期），获得其全部信息。
Class类：代表一个类
java中，无论生成某个类的多少个对象，这些对象都对应同样的一个Class对象，
Class对象描述了整个类的结构，JVM加载类时自动生成
 */

import java.lang.reflect.Method;

public class _01_获取class对象 {
    public static void main(String[] args) throws ClassNotFoundException {
       // args[0] = "java.lang.Object"; //注意是运行期
        Class<?> classType = Class.forName(args[0]);//方法1: 使用class类的静态方法，获取class对象，参数是类的全称
        Class<?> classType2 = Object.class;//方法2 ： 类名.class
        Class<?> classType3 = new Object().getClass();//方法3：通过对象获取

        System.out.println(classType.getClass());
        Method[] methods = classType.getMethods();
        for(Method method: methods) {
            System.out.println(method);
        }
    }
}
