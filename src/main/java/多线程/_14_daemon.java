package 多线程;

/**
 * @author wushang@tingyun.com
 * @date 2018/4/23
 */
/*
1 父线程设置daemon为false， 子线程设置为true：  父线程结束，子线程会继续执行，直到jvm中没有active线程
  即： 子线程被创建后，成为一个独立的线程，和父线程没有什么关系

 */
public class _14_daemon {

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程中又建立一个子线程
                Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println(Thread.currentThread().getName() + " doing");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, "thread-3");
                thread3.setDaemon(true);
//                thread3.setDaemon(false);
                thread3.start();

                System.out.println(Thread.currentThread().getName() + " doing");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }, "thread-1");
//        thread1.setDaemon(true);
        thread1.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println("thread-2 doing");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }, "thread-2").start();

        Thread.sleep(5000);
        System.out.println("main over---");
    }
}
