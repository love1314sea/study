package 多线程;

//实现Runnable来实现多线程
//如果要实现的类已经继承了另外一个类，只能使用这种方式来实现多线程。因为java是单继承的）
public class _02_thread {
    public static void main(String[] args) {
        //其实，Thread类也实现了Runnable方法
        Thread t1 = new Thread(new Thread_01());//调用Thread类的构造函数，Thread(Runnable target)
        System.out.println(t1.isAlive());
//        t1.start();
//
//
//        Thread t2 = new Thread(new Runnable() { //使用匿名内部类的方式，Runnable是个接口
//            @Override
//            public void run() {
//                for(int i=0; i<100; ++i ) {
//                    System.out.println("welcome:" + i);
//                }
//            }
//        });
//        t2.start();
//        t2.start(); // 线程已经结束,不能再次启动线程
    }
}
//实现Runnable接口，并重写run方法。因为是接口，没有构造函数，且接口中只有run方法，因此使用Thread中的start方法启动
class Thread_01 implements Runnable {

    public void run( ){
        for(int i=0; i<100; ++i ) {
            System.out.println("hello world:" + i);
        }
    }
}

