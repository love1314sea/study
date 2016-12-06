package 并发编程.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wushang on 16/7/6.
 */
public class _api {
    public void testArrayBlockingQueue() throws Exception{
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        queue.add("1");
        queue.add("2");
        queue.add("3");
//        queue.add("4"); //满了报异常
//        queue.offer("4"); //满了返回false
        System.out.println("满了阻塞--");
        queue.put("4");
        System.out.println("满了阻塞2--");
    }

    public void testArrayBlockingQueue2() throws Exception{
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        queue.add("1");
        System.out.println(queue.take());
        System.out.println("空了阻塞--");
        System.out.println(queue.take());
        System.out.println("空了阻塞2--");

    }

    public static void main(String[] args) throws Exception {
        _api demo = new _api();
//        demo.testArrayBlockingQueue();
        demo.testArrayBlockingQueue2();
    }
}
