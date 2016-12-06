package 多线程;


import java.util.Random;

public class _04_多线程共享资源 {

    public static void main(String[]  args ) {

        Thread04_1 r = new Thread04_1();
      //  Runnable r = new Thread04_1();  //Thread04_1  Runnable都可以
        //使用构造函数Thread(Runnable target)
        Thread t1 = new Thread(r);  // 使用同一个线程对象，创建了两个线程，两个线程共享成员变量，成员变量互相影响。
        Thread t2 = new Thread(r);
//        t1.setDaemon(true);
//        t2.setDaemon(true);
        t1.start(); //启动多线程必须使用start(),不能调用run()
        t2.start();
        System.out.println("main over-----");
    }
}

class Thread04_1 implements Runnable {

    int i = 0; //其实，成员变量就是多线程的共享资源。 线程类的成员变量，同一个对象的多个线程共享成员变量
                 // 多线程可以只读，但是修改的话需要同步技术。

    public void run() {
        // int i = 0; //但是run()中的局部变量不共享，各自一份。
        while(true) {
            System.out.println("number=" + i++);
            try {
                Thread.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(25 == i) {
                break;
            }
        }
    }
}