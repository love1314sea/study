package Collection.Properties;
/*
参考：http://blog.csdn.net/xichenguan/article/details/40895719
1.虚拟机自己结束时会调用，比如程序运行完成，或者用户跟虚拟机交互之后，虚拟机接收到退出信号，自己结束
2 外部力量结束虚拟机时，不能保证钩子线程启动，比如在windows平台中，启动任务管理器，直接将这个Java虚拟机关闭进程，这种情况下不能保证钩子线程一定会被调用
3 如果有多个钩子函数，它们的调用是无序的。
4 是用来监控JVM是否结束的，而不是监控线程
*/

public class _04_钩子函数测试 {
    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("I am still alive!");
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(Runtime.getRuntime().toString());
                    System.out.println(Runtime.getRuntime().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Runtime.getRuntime().toString());
        System.out.println(Runtime.getRuntime().hashCode());
        Thread.sleep(1000);
        System.out.println("I am exit!");
    }
}