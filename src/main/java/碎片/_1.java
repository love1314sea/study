package 碎片;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wushang on 15/8/22.
 */
public class _1 {
    public static void main(String[] args) {
        String[] arr;
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        arr = list.toArray(new String[3]);//

    }
}
