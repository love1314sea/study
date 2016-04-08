package spring.demo4生成实例;

import org.springframework.stereotype.Component;

/**
 * Created by wushang on 16/4/8.
 */
@Component
public class Bus extends Vehicle {
    @Override
    public void run() {
        System.out.println("bus run");
    }

    @Override
    public void stop() {
        System.out.println("bus stop");
    }
}
