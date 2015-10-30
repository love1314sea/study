package 并发编程.线程中断;

/**
 * Created by wushang on 15/10/12.
 */
//参考：http://blog.csdn.net/budapest/article/details/6941802
class TestRunnable1 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("run-------");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程阻塞时被中断");
        }
    }
}

public class _2_sleep时线程中断 {

    public static void main(String[] args) {
        Thread thread = new Thread(new TestRunnable1());
        thread.start();
        thread.interrupt();
    }
}
