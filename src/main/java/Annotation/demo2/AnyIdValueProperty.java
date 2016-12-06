package Annotation.demo2;

import java.lang.annotation.*;

/**
 * Created by wushang on 16/11/9.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnyIdValueProperty {
	public int fieldId();
}
