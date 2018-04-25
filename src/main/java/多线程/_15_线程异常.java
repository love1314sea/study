package 多线程;

/**
 * @author wushang@tingyun.com
 * @date 2018/4/25
 */
public class _15_线程异常 {

    public static void main(String[] args) {

        String s = null;

        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(s.length());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setUncaughtExceptionHandler((t, throwable) -> {
            System.out.println(t.getName() + " throw execption");
        });

        thread.start();


    }
}
