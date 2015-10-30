package 多线程;

//另外一种共享资源的使用看示例 06
public class _04_多线程共享资源_2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Bank_04();
        Thread t2 = new Bank_04();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("remain=" + Bank_04.money);
    }
}

class Bank_04 extends Thread{
    public static int money =  100;//静态成员变量称为共享变量
    public void run() { //添加syncronized修饰，并不管用，不能实现互斥访问。因为此方法不是start方法调用的，不是对象调用。
        money -= 60;  //如果多线程只读共享变量，可以使用这种方法。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(money);
    }
}
