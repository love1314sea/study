package 多线程;

//不能使用类中的stop方法终止线程执行，而是让他运行结束停止。
//不能依靠线程优先级来决定执行顺序
public class _03_线程停止 {
    public static void main(String[] args) throws InterruptedException {
        Thread03_1 t = new Thread03_1();
        t.start();
      //  t.start(); //一个线程对象只能启动一次
        Thread.sleep(10000);
        System.out.println(t.isAlive());//true
        t.stopRunning();

        System.out.println("-----------");
        Thread.sleep(5000);
        t.setFlag(true);
        Thread.sleep(1000);
        System.out.println(t.isAlive());//false
        t.start();//为什么线程死了，还是不能再次启动？？
        Thread.sleep(10000);
        t.stopRunning();
    }

}

class Thread03_1 extends Thread {
    private boolean flag = true;


    public void run(){
            while(flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; ++i) {
                    System.out.println("hello :" + i);
                }
            }
        }
    public void stopRunning() { //不能调用stop()方法，这是线程不安全的。
        flag = false;
    }
    public void setFlag(boolean b){
        flag = b;
    }

}