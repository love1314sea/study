//package spring.demo4生成实例;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
///**
// * Created by wushang on 16/4/8.
// */
//@ComponentScan("spring.demo4生成实例")
//public class Bootramp {
//    public static void main(String[] args) {
//        Bus bus = SampleContext.getBean(Bus.class);
//        bus.run();
//        Car car = SampleContext.getBean(Car.class);
//        car.run();
//
//        Map<String, Vehicle> map = SampleContext.getBeansOfType(Vehicle.class);
//        for(String key : map.keySet()) {
//            System.out.println("key = " + key);
//            System.out.println("value=" + map.get(key));
//        }
//    }
//}
