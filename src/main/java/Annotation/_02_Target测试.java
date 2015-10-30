package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@interface MyAnnotation02 {
    String value();
}

@MyAnnotation02("aaa")
public class _02_Target测试 {
    //@MyAnnotation02("aaa") //因为MyAnnotation02使用了Target，在此不能修饰方法
    public void output() {
        System.out.println("hhlo");
    }
}
