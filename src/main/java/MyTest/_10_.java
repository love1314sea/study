package MyTest;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 16/6/1.
 */
public class _10_ {
    public static void main(String[] args) {

//        int h =
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); //无符号右移16位,高位补0
        int h;
        int n = 8;
        System.out.println(n-1 & (h = 1000) ^ h >>> 16);
        System.out.println(n-1 & (h = 1001) ^ h >>> 16);
        System.out.println(n-1 & (h = 1002) ^ h >>> 16);
        System.out.println(n-1 & (h = 1003) ^ h >>> 16);
        System.out.println(n-1 & (h = 1004) ^ h >>> 16);
        System.out.println(n-1 & (h = 1005) ^ h >>> 16);
        System.out.println(n-1 & (h = 1006) ^ h >>> 16);
        System.out.println(n-1 & (h = 1007) ^ h >>> 16);
        System.out.println(n-1 & (h = 1008) ^ h >>> 16);
        System.out.println(n-1 & (h = 1009) ^ h >>> 16);
        System.out.println(n-1 & (h = 1010) ^ h >>> 16);

        System.out.println("---");
        System.out.println(n-1 & (h = 1000) );
        System.out.println(n-1 & (h = 1001) );
        System.out.println(n-1 & (h = 1002) );
        System.out.println(n-1 & (h = 1003) );
        System.out.println(n-1 & (h = 1004) );
        System.out.println(n-1 & (h = 1005) );
        System.out.println(n-1 & (h = 1006) );
        System.out.println(n-1 & (h = 1007) );
        System.out.println(n-1 & (h = 1008) );
        System.out.println(n-1 & (h = 1009) );
        System.out.println(n-1 & (h = 1010) );

        System.out.println("---");
        int i = 63;
        char c = (char)i;
        System.out.println(c);
        System.out.println("end---");

        long startTime = System.currentTimeMillis();
        String s = "ANR in com.nbs.testapp (com.nbs.testapp/com.nbs.activity.MainActivity) Reason: keyDispatchingTimedOut Load: 8.9 / 7.38 / 7.08 CPU usage from 18219ms to 0ms ago with 99% awake: 77% 367/system_server: 64% user + 12% kernel / faults: 242 minor 6.1% 18918/com.nbs.testapp: 4.2% user + 1.9% kernel / faults: 2022 minor 0.5% 50/mmcqd/0: 0% user + 0.5% kernel 0.2% 672/tx_thread: 0% user + 0.2% kernel 0.2% 45/bat_thread_kthr: 0% user + 0.2% kernel 0.2% 2475/logcat: 0.1% user + 0% kernel 0.1% 451/com.android.systemui: 0.1% user + 0% kernel 0.1% 4265/logcat: 0% user + 0.1% kernel 0.1% 6331/logcat: 0% user + 0.1% kernel 0.1% 6526/logcat: 0% user + 0.1% kernel 0.1% 8054/logcat: 0.1% user + 0% kernel 0.1% 9805/logcat: 0% user + 0.1% kernel 0.1% 10030/logcat: 0.1% user + 0% kernel 0.1% 11222/logcat: 0.1% user + 0% kernel 0.1% 11307/logcat: 0.1% user + 0% kernel 0.1% 11409/logcat: 0.1% user + 0% kernel 0.1% 11510/logcat: 0.1% user + 0% kernel 0.1% 14062/logcat: 0.1% user + 0% kernel 0.1%";
        s.hashCode();
        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);


        byte[] a = "hello boy ddfdfdfsfsdfsfsfsfs".getBytes();
        byte[] b = "hello boy ddfdfdfsfsdfsfsfsfs".getBytes();
        System.out.println(DigestUtils.md5Hex(a));
        System.out.println(DigestUtils.md5Hex(b));


    }
}
