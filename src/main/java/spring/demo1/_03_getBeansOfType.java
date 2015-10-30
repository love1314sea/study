package spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by wushang on 15/10/21.
 */
//http://www.blogjava.net/jlin/articles/298269.html
public class _03_getBeansOfType {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-demo1.xml");//lu
        Map map = context.getBeansOfType(Performer.class,false,false);
        System.out.println(map.size());
    }
}

