package guava._05_EventBus.Demo1;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Created by wushang on 15/10/20.
 */
public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:"+lastMessage);
    }
    @Subscribe  //需要注解
    public void listen(Integer integer) {  //函数名字任意，根据参数类型来决定调用哪个函数
        System.out.println("Integer message:" + integer );
    }

    @Subscribe
    public void listenInteger(Integer integer) {
        System.out.println("Integer message2:" + integer );
    }

    @Subscribe
    //如果没有消息订阅者监听消息， EventBus将发送DeadEvent消息，这时我们可以通过log的方式来记录这种状态。
    public void listenDeadEvent(DeadEvent deadEvent) {
        System.out.println("dead evnet");
    }
    public int getLastMessage() {
        return lastMessage;
    }
}