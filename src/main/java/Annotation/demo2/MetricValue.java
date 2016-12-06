package Annotation.demo2;

/**
 * Created by wushang on 16/7/21.
 */


import java.io.Serializable;

/**
 * Created by wushang on 16/6/20.
 */
@AnyIdClassProperty(classId = 1)
public class MetricValue implements Serializable {
	private static final long serialVersionUID = 4652283696608573322L;
	@AnyIdValueProperty(fieldId = 2)
	String name;
}