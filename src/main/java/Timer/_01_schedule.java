package Timer;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wushang on 15/6/26.
 */
public class _01_schedule {
    Timer timer;
    public _01_schedule() {
        timer = new Timer();
        timer.schedule(new TimerTaskDemo1(),1000,2000);// 如果new TimerTaskDemo1()中run函数执行时长大于间隔时间2000，则上一次的结束时间是这一个次的开始时间。
                                                      // 如果执行时长小于2000，则按照间隔时间执行。
    }
    public static void main(String[] args) {
        System.out.println("begin---");
        new _01_schedule();

    }
}

class TimerTaskDemo1 extends TimerTask {
    @Override
    public void run() {
        try {
            Thread.sleep(5000); //休眠5钟，注意打印结果。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("本次执行该线程的时间为：" + date);
    }
}
