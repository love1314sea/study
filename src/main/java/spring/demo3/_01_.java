package spring.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 15/10/21.
 */
//要么都用构造函数构造，要么都用set方法，不能混用
public class _01_ {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo3/spring-demo.xml");
        Performer performer = (Performer)context.getBean("juggler");
        performer.perform();
    }
}
