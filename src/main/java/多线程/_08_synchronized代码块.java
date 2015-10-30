package 多线程;

/*
synchronized保护的数据应该是私有的(private)的，如果是public，可以通过对象修改，就无法保护了。
我觉得，此处的数据指的应该是成员变量。
 */

public class _08_synchronized代码块 {

    public static void main(String[] args) {
        Example08 e = new Example08();
        Thread t1 = new TheThread08_1(e);
       //  e = new Example08();  //传入不同的对象
        Thread t2 = new TheThread08_2(e);

        t1.start();
        t2.start();
    }
}

class Example08{

  //  static Object object = new Object(); //如果是静态的，则传入不同对象也能实现同步。
    Object object = new Object();

    public void execute1() throws InterruptedException {
        synchronized (object) { //synchronized代码块，锁住这个对象，更精细粒度的管理代码
            for (int i = 0; i < 20; ++i) {
                Thread.sleep(1000);
                System.out.println("hello :" + i);
            }
        }
    }

    public void execute2() throws InterruptedException {
        synchronized (object) {
            for (int i = 0; i < 20; ++i) {
                Thread.sleep(1000);
                System.out.println("world :" + i);
            }
        }
    }
}
class TheThread08_1 extends Thread {
    Example08 e;
    public TheThread08_1(Example08 e){
        this.e = e;
    }
    public void run() {
        try {
            this.e.execute1();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
class TheThread08_2 extends Thread {
    Example08 e;
    public TheThread08_2(Example08 e) {
        this.e = e;
    }
    public void run() {
        try {
            this.e.execute2();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
