package 多线程.优雅关闭线程;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ThreadCloseForce {


    public static void main(String[] args) throws Exception{

        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            //load a very heavy resource.
            /*while (true) {

            }*/
            try {
                Thread.sleep(15000);
                System.out.println("execute----");
            } catch (InterruptedException e) {
                e.printStackTrace();  //我认为是有问题的： 执行线程的结束是因为jvm中没有active线程，而不是因为父线程结束
            }
        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        Thread.sleep(100000);
    }
}