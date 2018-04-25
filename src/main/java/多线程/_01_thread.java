package 多线程;

// 方法1：继承Thread类实现多线程
public class _01_thread {

    public static void main(String[] args) throws Exception{
        Thread_1 t1 = new Thread_1();
        t1.start();
        t1.start();
        Thread_2 t2 = new Thread_2();
        t2.start();

        System.out.println(t2.getName());
        Thread t3 = new Thread_2("hello-thread");// 传入线程名称
        System.out.println(t3.getName());

    }
}

//方法1：继承Thread类，并重写run方法，启动时必须使用start()方法
class Thread_1 extends Thread {

    public void run() {
        for(int i=0; i<100; ++i ) {
            System.out.println("hello world:" + i);
        }
    }
}

class Thread_2 extends Thread {

    public Thread_2(String name) {
        super(name);
    }
    public Thread_2( ) {
        super();
    }
    public void run() {
        for(int i=0; i<100; ++i ) {
            System.out.println("welcome:" + i);
        }
    }


}