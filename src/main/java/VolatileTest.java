/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
public class VolatileTest {

    private static  int INIT_VALUE = 0;
    private static volatile boolean flag = false;

    private final static int MAX_LIMIT = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
//            while (flag) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
            }
        }, "UPDATER").start();
    }
}
