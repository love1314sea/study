package Annotation.demo2;

import java.lang.annotation.*;

/**
 * Created by wushang on 16/7/29.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnyIdClassProperty {
	public int classId();
}
