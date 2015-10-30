package 多线程;
//如果某个 synchronized 方法是static的，那么当线程访问改方法时，它锁的并不是synchronized方法
//所在的对象，而是synchronized 所在对象所对应的class对象。
// 因为java中无论一个类中有多少个对象，这些对象会对应唯一的class对象。因为当线程分别访问同一个类的
// 两个对象的static synchronized 方法时，他们的执行循序也是顺序的：虽然是两个不同对象，但是因为是
// static 方法。
// 那么，如果一个类中有一个static方法，一个普通方法，这两个方法都访问共享资源，且用synchronized修饰，
//但不能达到线程同步的目标。这两个方法的访问仍然是乱序的。

public class _07_多线程与static方法 {

    public static void main(String[] args) {
        Example07 e = new Example07();
        Thread t1 = new TheThread07_1(e);
      //  e = new Example07();  //传入不同的对象
        Thread t2 = new TheThread07_2(e);

        t1.start();
        t2.start();
    }

}

class Example07{
    // 如果函数execute1()和execute2()中有相同的资源，即相同的传入参数Example07对象e，我们不希望这两段代码同时执行，则使用线程同步。

    public static synchronized void execute1() throws InterruptedException {
        for(int i=0; i<20; ++i ) {
            Thread.sleep(1000);
            System.out.println("hello :" + i);
        }
    }
// 如果main函数，传入相同的对象，但是一个方法是static的，另外一个不是static的，则也不能实现互斥访问
// 除非两个都是static，或都不是static的。
// 但如果main函数传入的是不同的对象，如果两个都是static方法，也能实现线程同步。因为synchronized此时作用的class对象。
    public static synchronized void execute2() throws InterruptedException {
        for(int i=0; i<20; ++i ) {
            Thread.sleep(1000);
            System.out.println("world :" + i);
        }
    }
}
class TheThread07_1 extends Thread {
    Example07 e;
    public TheThread07_1(Example07 e){
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
class TheThread07_2 extends Thread {
    Example07 e;
    public TheThread07_2(Example07 e) {
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