package jmx.MBean;

/**
 * Created by wushang on 2017/3/26.
 */

import jmx.MBean.Hello;

import java.lang.management.*;
import javax.management.*;

/*
参考: http://blog.csdn.net/derekjiang/article/details/4531952
 */

public class Main {

	public static void main(String[] args)
			throws Exception {

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.example:type=Hello");
		Hello mbean = new Hello();
		mbs.registerMBean(mbean, name);


		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
	}
}
