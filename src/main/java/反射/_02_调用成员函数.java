package 反射;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class _02_调用成员函数 {
    public int add(int a, int b) {
        return a+b;
    }
    public String echo(String str) {
        return "hello : " + str;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //往常的使用
        _02_调用成员函数 test = new _02_调用成员函数();
        System.out.println( test.add(1,2));
        System.out.println( test.echo("world"));
        System.out.println("-------------");
        //使用反射

        Class<?> classType = _02_调用成员函数.class;//首先获得类唯一的class对象
        //其次，获得方法对应的Method对象，参数1：方法名  参数2：可变参数， 函数的参数对应的class对象
        Method method = classType.getMethod("add",new Class[]{int.class, int.class});
        //获得一个类所对应的对象
        Object invokeTester = classType.newInstance();//newInstance,只能调用无参构造函数
        //Method对象调用invoke方法，参数1：调用哪个对象的方法  参数2：传入的参数
        Object result = method.invoke(invokeTester, new Object[]{1,2});
        System.out.println((Integer)result);//返回类型int会自动装箱

        Method method1 = classType.getMethod("echo", new Class[]{String.class});
        Object result1 = method1.invoke(invokeTester, new Object[]{"girl"});
        System.out.println((String)result1);
    }
}
