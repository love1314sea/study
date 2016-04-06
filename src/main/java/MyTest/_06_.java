package MyTest;

import java.util.ArrayList;

/**
 * Created by wushang on 15/12/5.
 */
public class _06_ {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b"};
        Object o = arr;
        for(String str: (String[])o) {
            System.out.println(str);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add(1,"a");

    }
}
