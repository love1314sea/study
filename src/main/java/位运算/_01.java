package 位运算;

import java.util.ArrayList;

/**
 * Created by wushang on 15/11/20.
 */
public class _01 {
    public static void main(String[] args) {
        int i = 126;
        int j = i >> 1;
        int k = i << 1;
        System.out.println(j);
        System.out.println(k);

        int s = -1;
        System.out.println(s >> 10);

        System.out.println(15&11111155);
        System.out.println(15 & -3);
    }
}
