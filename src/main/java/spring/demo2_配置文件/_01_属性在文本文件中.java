package spring.demo2_配置文件;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 15/10/21.
 */
/*
spring-demo2.xml 中定义了org.springframework.beans.factory.config.PropertyPlaceholderConfigurer对象，
程序启动，会加载里面的配置文件；生成属性的map；后面的配置可以使用变量配置
参考：http://blog.csdn.net/sz_bdqn/article/details/6666262
 */
public class _01_属性在文本文件中 {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo2/spring-demo2.xml");
        DataDao dataDao = (DataDao)context.getBean("datadao");
        System.out.println(dataDao.getUserName());
    }
}
