package 反射;
/*
调用private方法：
1 使用getDeclaredMethod，能获得private方法的对象
2 设置  method.setAccessible(true),不让进行安全检查
调用private成员变量：
1 使用getDeclaredField
2 field.setAccessible(true);
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class _08_反射调用private方法和变量 {
    public static void main(String[] args) throws Exception{
        Private p = new Private();
        Class<?> classType = p.getClass();
        //调用private方法
        Method method = classType.getDeclaredMethod("sayHello", new Class[]{String.class});
        method.setAccessible(true);
        Object obj = method.invoke(p, new Object[]{"world"});
        System.out.println((String)obj);

        //更改private name为lisi
        Field field = classType.getDeclaredField("name");
        field.setAccessible(true);
        field.set(p,"lisi");
        Object obj2 = field.get(p);
        // Object obj2 = field.getName();
        System.out.println((String)obj2);

    }
}
class Private {
    private String name = "zhangsan";
    private String sayHello(String str) {
        return "hello :" + str;
    }
}