package 设计模式.观察者模式.demo4;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
interface Monitor {

    public void onEvent(MonitoredRunnable.RunnableEvent state);
}
