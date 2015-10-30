package guava._05_EventBus.Demo1;

import com.google.common.eventbus.EventBus;

/**
 * Created by wushang on 15/10/20.
 */
//http://www.cnblogs.com/peida/p/EventBus.html
public class TestEventBus {

    public static void main(String[] args) throws Exception {



        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener(); //自定义的监听者

        eventBus.register(listener);//注册监听对象

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));
        eventBus.post(5); //可以post任何类型,因为post(Object object)
        eventBus.post("hello");//发送DeadEvent
        System.out.println("LastMessage:"+listener.getLastMessage());
        ;
    }
}