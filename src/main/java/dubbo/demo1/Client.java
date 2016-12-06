package dubbo.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 16/6/12.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-client.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("userService");
        System.out.println(demoService.getUsers());
    }
}
