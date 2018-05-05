package 多线程;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
public class _16_exit {

    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " exit jvm");
                System.exit(100);
            }
        },"thread-1").start();


        Thread.sleep(5000);

        System.out.println("main over---");
    }
}
