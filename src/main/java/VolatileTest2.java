/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
public class VolatileTest2 {

    private static  boolean init = false;


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!init) {
                System.out.println("over");
            }
        }, "READER").start();

        Thread.sleep(1000);
        new Thread(() -> {
            init = true;
        }, "UPDATER").start();
    }
}
