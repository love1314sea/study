package 调优;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by wushang on 15/11/28.
 */
public class _02_字符串分割 {
    public static String orgStr = generateString();
    public static final int NUM = 100000;


    public static String generateString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 100; i++) {
            sb.append(i);
            sb.append(";");
        }
        return sb.toString();
//        return  "112aaaaaaaaaaahhdkjflfdsfjdsofdslfsdfsdjlfds.fsdflsdflsdjfsdfsdlfsdfsdlfsdlfsdjfksdlflds;dfdsfsdfsdfsdfdsfdsfsdfsdfsdfsdfsdfsdfsdfadsfdfdsf;fsdfsfdsfsdfdsfsdfdsfdsfsdfsd";
    }

    public static void testSplit() {
        long bt = System.currentTimeMillis();
        for (int i = 0; i < NUM; ++i) {
            orgStr.split(";",-1);
//            String[] arr = orgStr.split(";");
//            for(String str: arr) {
//                System.out.println(str);
//            }
        }
        long dt = System.currentTimeMillis() - bt;
        System.out.println("split:" + dt);
    }

    public static void testTokenizer() {
        long bt = System.currentTimeMillis();

        StringTokenizer st = new StringTokenizer(orgStr, ";");
        for (int i = 0; i < NUM; ++i) {
            while (st.hasMoreTokens()) {
                st.nextToken();
//                System.out.println(st.nextToken());
            }
            st = new StringTokenizer(orgStr, ";");
        }
        long dt = System.currentTimeMillis() - bt;
        System.out.println("token:" + dt);
    }

    public static void testIndex() {
        String tmp = orgStr;
        long bt = System.currentTimeMillis();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < NUM; ++i) {
            while (true) {
                String splitStr = null;
                int j = tmp.indexOf(';');
                if (j < 0) break;
                splitStr = tmp.substring(0, j);
                tmp = tmp.substring(j+1);//每次都生成新的字符串，且利用率较低，大量gc
                list.add(splitStr);
//                System.out.println(splitStr);
            }
            tmp = orgStr;
        }
        long dt = System.currentTimeMillis() - bt;
        System.out.println("index:" + dt);
    }

    //根据split，仿写的代码
    public static void testIndex2() {
        String tmp = orgStr;
        long bt = System.currentTimeMillis();
        for (int i = 0; i < NUM; ++i) {
            int off = 0;
            int next = 0;
            ArrayList<String> list = new ArrayList<>();
            while ((next = tmp.indexOf(';', off)) != -1) {//重用原来的字符串，降低内存和gc
                    list.add(tmp.substring(off, next));
                    off = next + 1;
                }
            list.add(tmp.substring(off));
            list.subList(0,list.size()).toArray(new String[0]);
        }
        long dt = System.currentTimeMillis() - bt;
        System.out.println("index2:" + dt);
    }

    public static void main(String[] args) {

        testSplit();//当字符串长时，最快
        testIndex2();// 最好的方法

        testTokenizer();//
        testIndex();//当被分割后的字符串段数少，效率高；但代码中生成大量临时的字符串，效率急剧下降

    }
}
