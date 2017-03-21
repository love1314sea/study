package spring.接口测试;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 17/3/8.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-interface-test.xml");
		Car car = (Car) context.getBean("car");
		car.run();
	}
}
