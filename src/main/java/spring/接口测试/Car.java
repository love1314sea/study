package spring.接口测试;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by wushang on 17/3/8.
 */
// 参考: http://uule.iteye.com/blog/2094549
public class Car implements InitializingBean, DisposableBean, BeanPostProcessor{


	private String brand;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void run() {
		System.out.println("car run--");
	}

	//接口中的两个方法都要将传入的bean返回，而不能返回null，如果返回的是null那么我们通过getBean方法将得不到目标。
	@Override
	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		System.out.println("postProcessBeforeInitialization--- ");
		return o;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet ---");
	}

	@Override
	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
		System.out.println("postProcessAfterInitialization----");
		return o;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy ---- ");
	}
}
