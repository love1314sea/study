package Annotation.demo1;
/*
1 当我们使用@interface关键字来定义一个注解时，该注解隐含的继承了java.lang.annotation.Annotation这个接口；
2 但如果我们定义一个接口，并且让该继承自java.lang.annotation.Annotation，我们定义的接口仍然是接口，而不是注解
3 Annotation本身是接口而不是注解
4 自定义注解只有使用@interface关键字
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
有三种RetentionPolicy，为SOURCE/CLASS/RUNTIME
*/
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {//定义一个annocation，类似Override、Deprecated等注解

	String hello() default "china"; //成员变量设置一个默认值

	String world();
}


@MyAnnotation(hello = "bj", world = "beijing")
//修饰类
class MyTest {
	@MyAnnotation(hello = "tj", world = "tianjing")//修饰方法
	@Deprecated
	@SuppressWarnings("unchecked")  //方法或类都可以有多个注解修饰
	public void output() {
		System.out.println("this is output");
	}
}

@MyAnnotation(hello = "sh", world = "shanghai")
class SubMyTest extends MyTest{
	public void input() {
		System.out.println("please input something");
	}
}