package spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 15/10/21.
 */
public class _02_测试bean作用域 {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-demo1.xml");
        Performer performer1 = (Performer) context.getBean("juggler");
        Performer performer2 = (Performer)context.getBean("juggler");
        if(performer1 == performer2) {
            System.out.println("the same one");//默认作用域是singleton,所以一致
        } else {
            System.out.println("not the same ont");
        }

        Performer performer3 = (Performer)context.getBean("juggler2");
        if(performer1 == performer3) {
            System.out.println("the same one");
        } else {
            System.out.println("not the same one");//不是同一个bean，所以不一致
        }

        Performer performer4 = (Performer)context.getBean("juggler2");
        if(performer3 == performer4) {
            System.out.println("the same one");
        } else {
            System.out.println("not the same one");//scope设置的为prototype,每一个调用都生成一个新的对象
        }
    }
}
