package spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 15/10/21.
 */
public class _01_面向接口编程 {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-demo1.xml");//lu
        Performer performer = (Performer)context.getBean("perform");
        performer.perform();
    }
}
