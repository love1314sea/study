package Timer;

import java.util.Date;
import java.util.TimerTask;

import java.util.Timer;
/**
 * Created by wushang on 15/6/26.
 */
public class _02_scheduleAtFixedRate {
    Timer timer;
    public _02_scheduleAtFixedRate() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTaskDemo2(), 1000, 2000);//总是以固定速率执行，不管任务执行时长。
    }
    public static void main(String[] args) {
        new _02_scheduleAtFixedRate();
    }
}

class TimerTaskDemo2 extends TimerTask {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("本次执行该线程的时间为：" + date);
    }
}