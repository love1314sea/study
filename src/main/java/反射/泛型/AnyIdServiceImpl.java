package 反射.泛型;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wushang on 2017/11/23.
 */
public class AnyIdServiceImpl extends AnyIdService<String> {



	public AnyIdServiceImpl(){
		Type vType = getClass().getGenericSuperclass();

//		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//		Class clazz = (Class) type.getActualTypeArguments()[0];
////		System.out.println(clazz);
//

		Class c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
//          System.out.println("in if");
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
//          System.out.println(Arrays.toString(p));
			Class clazz = (Class) p[0];
			System.out.println(clazz.getName());
		}

//		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();//获取当前new对象的泛型的父类类型
//		Class clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
//		System.out.println("clazz ==>> "+clazz);

//		if (vType instanceof ParameterizedType) {
//			Type[] params = ((ParameterizedType) vType).getActualTypeArguments();
//			Class<T> vClass = (Class<T>) params[0];
//			Class clazz = ((ParameterizedType) vType).getActualTypeArguments()[0];
//
//			if (vClass != Object.class) {
////				this.valuesClass = vClass;
//				System.out.println("yes");
//			}
//		}
	}



}
