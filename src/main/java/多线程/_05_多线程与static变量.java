package 多线程;


public class _05_多线程与static变量 {
    public static void main(String[] args) throws Exception{
        Bank bank = new Bank();

        Thread t1 = new TheThread05(bank);

       // bank = new Bank(); //重新赋值做对比：重新赋值，t1 t2是不同的参数对象。
        Thread t2 = new TheThread05(bank);

        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println(bank.money);
    }
}

class Bank {
    public int money = 1000; //定义时，并赋值
//    private static int money = 1000; //添加static，并定义两个对象做对比。 虽然是两个对象，但拥有同一份静态成员变量

    public  int getMoney(int m) {//添加 synchronized 做对比
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        money -= m;
        System.out.println("left = " + money);
        return m;
    }
}

class TheThread05  extends Thread {
    private Bank bank;
    public TheThread05(Bank b) {
        bank = b;
    }
    public void run() {
        bank.getMoney(600);
    }
}