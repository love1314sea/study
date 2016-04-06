package volatile_;

/**
 * Created by wushang on 16/3/24.
 */
public class _1_teset {


    public static void main(String[] args) throws Exception{
        MyThread thread1 = new MyThread("aaa");
        thread1.start();
        MyThread thread2 = new MyThread("bbb");
        thread2.start();

        Thread.sleep(5000);
        thread1.stopIt();
        System.out.println("over---");
    }
}

class MyThread extends Thread {
    private static volatile boolean isStop = false;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void stopIt() {
        isStop = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (!isStop) {
            try {
                Thread.sleep(1000);
                System.out.println(name + ":exe ----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}