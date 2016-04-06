package 并发编程.ThreadLocal;

/**
 * Created by wushang on 15/10/14.
 */
//ThreadLocal会为每一个线程提供一个独立的变量副本
//http://www.cnblogs.com/dolphin0520/p/3920407.html
//http://blog.csdn.net/lufeng20/article/details/24314381
//考察输出的结果信息，我们发现每个线程所产生的序号虽然都共享同一个TestNum实例，
// 但它们并没有发生相互干扰的情况，而是各自产生独立的序列号，这是因为我们通过ThreadLocal为每一个线程提供了单独的副本。
public class _1_实现自己的 {

    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() { //
        public Integer initialValue() {
            return 0;
        }
    };
    private int count = 0;//  与 ThreadLocal对比
    // ②获取下一个序列值
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public int getNextCount() {
        return count+=1;
    }

    public static void main(String[] args) {
        _1_实现自己的 sn = new _1_实现自己的();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private _1_实现自己的 sn;

        public TestClient(_1_实现自己的 sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + sn.getNextNum() + "]");
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[next count="  + sn.getNextCount() + "]");
            }
        }
    }
}
