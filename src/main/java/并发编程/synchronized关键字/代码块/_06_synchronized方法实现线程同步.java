package 并发编程.synchronized关键字.代码块;

//线程同步有：synchronized方法和synchronized块
//synchronized方法粗粒度，synchronized块细粒度，最好使用synchronized块
public class _06_synchronized方法实现线程同步 {

    public static void main(String[] args) throws InterruptedException {
        Example example = new Example(); //example对象称为共享资源。

        Thread t1 = new TheThread(example); //两个线程传入同一个对象example
        Thread t2 = new TheThread(example);

        t1.start();
        t2.start();
        Thread.sleep(2000);
        example.say();  //访问synchronized函数时，会给这个example对象加锁，锁住的是对象中所有synchronized方法，
        //其他的synchronized方法也是不可访问的，但普通方法仍可以访问。
    }

}

class Example {

    public synchronized void execute() { //synchronized修饰方法，锁住example对象，实现线程同步
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public  void say() {  //可以在此方法前加 synchronized测试结果不同
        System.out.println("hello world");
    }
}

class TheThread extends Thread {
    private Example example;
//    private static Object object = new Object();

    public TheThread(Example example) {
        this.example = example;
    }

    public void printThreadName() throws InterruptedException {  //虽然函数中有synchronized关键字，但是如果是不同对象执行，还是乱序
        synchronized(Integer.class) { //如果是
            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                System.out.println(i + " Thread name =" + Thread.currentThread().getName());
            }
        }
    }

    @Override
    public void run() {
        try {
            printThreadName();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.example.execute();
    }
}