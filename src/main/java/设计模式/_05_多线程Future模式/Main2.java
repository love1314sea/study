package 设计模式._05_多线程Future模式;


/**
 * @author wushang@tingyun.com
 * @date 2018/5/5
 */
/*
使用回调
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        FutureService service = new FutureService();
        Future<String> future = service.submit(new FutureTask<String>() {
            @Override
            public String call() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello";
            }
        }, System.out::println);

        System.out.println("----------");

    }
}
