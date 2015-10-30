package Annotation;
/*
1 必须是RetentionPolicy.RUNTIME，才能在jvm中使用反射获得Annotation
2 Class-》Method-》Annotation
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class _01_反射中获得Annotation {
    public static void main(String[] args) throws Exception {
        MyTest myTest = new MyTest();

        Class<MyTest> clssType = MyTest.class;
        Method method = clssType.getDeclaredMethod("output", new Class[]{});
        method.invoke(myTest,new Object[]{});

        if(method.isAnnotationPresent(MyAnnotation.class)) {//是否存在
            //获得修饰方法的Annotation,返回值是自己定义的MyAnnotation类型
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            String hello = annotation.hello();
            String world = annotation.world();
            System.out.println("hello=" + hello);
            System.out.println("world=" + world);
        }
        System.out.println("-------------------");
        Annotation[] annotations = method.getAnnotations();//获得所有修饰的Annotation
        for(Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName());
            System.out.println(annotation.getClass().getName()); //比较二者区别
        }
    }
}
