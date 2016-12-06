//package spring.demo4生成实例;
//
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.MessageSourceResolvable;
//import org.springframework.context.NoSuchMessageException;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.Resource;
//
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.util.Locale;
//import java.util.Map;
//
///**
// * Created by wushang on 16/4/8.
// */
//public class SampleContext {
//    private final ApplicationContext applicationContext;
//    private final static SampleContext sington = new SampleContext();
//
//    private SampleContext() {
//        applicationContext = new AnnotationConfigApplicationContext(Bootramp.class);// 必须和注解相互使用
//    }
//
//    public SampleContext me() {
//        return sington;
//    }
//
//    public static <T> T getBean(Class<T> type) {
////        type.newInstance();
//        return sington.applicationContext.getBean(type);
//    }
//
//    public static <T> Map<String, T> getBeansOfType(Class<T> type) { // type不能为接口,应该是抽象类
//        return sington.applicationContext.getBeansOfType(type);
//    }
//}
