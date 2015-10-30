package 并发编程.BlockingQueue.demo1;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wushang on 15/10/15.
 */
public class _1 {
    public static void main(String[]  args) {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<String>(10);
        list.add("1");
        System.out.println(list.size());
        list.add("1");
        System.out.println(list.size());

    }
}
