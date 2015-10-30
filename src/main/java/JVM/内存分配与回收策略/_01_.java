package JVM.内存分配与回收策略;

/**
 * Created by wushang on 15/10/16.
 */
public class _01_ {
    private static final int _1MB = 1024*1024;
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

        allocation4 = new byte[1 * _1MB];

    }
    public static void main(String[] args) {
        testAllocation();
    }
}
