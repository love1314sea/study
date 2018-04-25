package 多线程.线程通信.生产者消费者;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wushang@tingyun.com
 * @date 2018/4/24
 */
public class Test {

    private final Object LOCK = new Object();
    private List<String> list = new ArrayList<String>();

    public void produce() {
        synchronized (LOCK) {
            while (true) {
                if (list.size() == 5) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(String.valueOf(list.size()));
                    break;
                }
            }
            LOCK.notifyAll();
        }
    }

    public String consume() {
        String result = null;
        synchronized (LOCK) {
            while (true) {
                if (list.size() == 0) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    result = list.remove(0);
                    break;
                }
            }
            LOCK.notifyAll();
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    test.produce();
                }
            }
        },"produce1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    test.produce();
                }
            }
        },"produce2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    test.consume();
                }
            }
        },"consumer1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    test.consume();
                }
            }
        },"consumer2").start();

    }
}
