package 并发编程.线程中断;

/**
 * Created by wushang on 15/10/29.
 */
public class _3_this调用 extends Thread{
    @Override
    public void run() {
        int count = 0;
        while(!Thread.interrupted()) {
            count++;
            System.out.println("count=" + count);
            if(count == 5) {
                this.interrupt(); //中断自身
            }
        }
        System.out.println("over---");
    }

    public static void main(String[] args) {
        new _3_this调用().start();
    }
}
