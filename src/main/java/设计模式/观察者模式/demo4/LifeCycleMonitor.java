package 设计模式.观察者模式.demo4;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
public class LifeCycleMonitor implements Monitor {


    @Override   //处理各种事件
    public synchronized void onEvent(MonitoredRunnable.RunnableEvent event) {

        System.out.println(event);

    }
}
