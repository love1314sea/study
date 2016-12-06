package Annotation.demo2;

import java.util.Objects;

/**
 * Created by wushang on 16/7/29.
 */
public class Demo {
	public static void main(String[] args) {
		AnyIdClassProperty classProperty = MetricValue.class.getAnnotation(AnyIdClassProperty.class);
		if(classProperty == null) {
			System.out.println("wrong");
			return;
		}
		int i = classProperty.classId();
		System.out.println(i);

		Integer a = new Integer(3);
		Integer b = new Integer(3);
		System.out.println(Objects.equals(a,b));

		System.out.println(a == b);
	}
}
