package 并发编程.线程中断;

/**
 * Created by wushang on 15/10/12.
 */

class TestRunnable implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while(true) {
            System.out.println(i++);
        }
    }
}

class TestRunnable2 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        System.out.println("是否中断:" + Thread.currentThread().isInterrupted());

        while (!Thread.currentThread().isInterrupted()) { //没有中断信号，返回true;有中断信号，返回false

            System.out.println(i++);
        }
        System.out.println("进程中断状态被置为:" + Thread.currentThread().isInterrupted());
    }
}
//通过与TestRunnable2对比：interrupted 和isInterrupted的异同
/*
相同：都获得线程的中断状态
不同：1 interrupted是静态成员函数；isInterrupted 是普通成员函数
     2 interrupted会重置中断状态为false； isInterrupted不会有动作
 */
class TestRunnable3 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        System.out.println("是否中断:" + Thread.currentThread().isInterrupted());

        while (!Thread.interrupted()) {  //通过与TestRunnable2对比：interrupted和isInterrupted的异同

            System.out.println(i++);
        }
        System.out.println("进程中断状态被置为:" + Thread.currentThread().isInterrupted());
    }
}
public class _1_test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestRunnable());
        thread.start();
        thread.interrupt(); //并没有中断cpu，终止线程的执行
//
//        Thread thread2 = new Thread(new TestRunnable2());
//        thread2.start();
//        Thread.sleep(10);
//        thread2.interrupt();

//        Thread thread3 = new Thread(new TestRunnable3());
//        thread3.start();
//        Thread.sleep(10);
//        thread3.interrupt();
    }
}
