package 多线程.线程通信.生产者消费者;


public class TestMain {
    public static void main(String[] args) {
        Sample e = new Sample();

        Thread t1 = new DecreaseThread(e);

        Thread t2 = new IncreaseThread(e);

        Thread t3 = new DecreaseThread(e);

        Thread t4 = new IncreaseThread(e);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
