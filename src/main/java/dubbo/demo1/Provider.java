package dubbo.demo1;

/**
 * Created by wushang on 16/6/12.
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo.xml"});
        context.start();

        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }

}