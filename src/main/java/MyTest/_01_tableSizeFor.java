
package MyTest;

/**
 * Created by wushang on 15/12/2.
 */
public class _01_tableSizeFor {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.print("n=" + n + " ");
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void main(String[] args) {
        System.out.println(tableSizeFor(-1));//n=-1 1
        System.out.println(tableSizeFor(0));//n=-1 1
        System.out.println(tableSizeFor(1));//n=0 1
        System.out.println(tableSizeFor(100));//n=127 128
        System.out.println(tableSizeFor(129));//n=255 256
        System.out.println(tableSizeFor(130));//n=255 256
    }
}
