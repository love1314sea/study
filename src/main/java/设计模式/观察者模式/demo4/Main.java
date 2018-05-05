package 设计模式.观察者模式.demo4;


import static 设计模式.观察者模式.demo4.MonitoredRunnable.RunnableState.DONE;
import static 设计模式.观察者模式.demo4.MonitoredRunnable.RunnableState.ERROR;
import static 设计模式.观察者模式.demo4.MonitoredRunnable.RunnableState.RUNNING;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
public class Main {
    public static void main(String[] args) throws Exception {


        LifeCycleMonitor lifeCycleMonitor = new LifeCycleMonitor();//多线程共享，注意线程安全

        new Thread(new MonitoredRunnable(lifeCycleMonitor) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RUNNING, Thread.currentThread(), null));
                    Thread.sleep(1000);
                    notifyChange(new RunnableEvent(DONE, Thread.currentThread(), null));

                } catch (InterruptedException e) {
                    notifyChange(new RunnableEvent(ERROR, Thread.currentThread(), null));
                }

            }
        },"thread1").start();


        new Thread(new MonitoredRunnable(lifeCycleMonitor)  {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RUNNING, Thread.currentThread(), null));
                    Thread.sleep(1000);
                    notifyChange(new RunnableEvent(DONE, Thread.currentThread(), null));

                } catch (InterruptedException e) {
                    notifyChange(new RunnableEvent(ERROR, Thread.currentThread(), null));
                }

            }
        },"thread2").start();
    }
}
