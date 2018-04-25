package 多线程.线程中断;

/**
 * @author wushang@tingyun.com
 * @date 2018/4/23
 */
public class _2_ {


    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int v =0;
                    for(int i=0;i<1000000000L; ++i){
                        v+=i;
                    }
                    System.out.println("begin---");
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        Thread.sleep(10);
        thread.interrupt();
        System.out.println("over interrupt");
        System.out.println(thread.isInterrupted()); //设置了中断信号，然后有wait()阻塞，同样会抛出 异常

        Thread.sleep(100);
        System.out.println(thread.isInterrupted());
    }
}
