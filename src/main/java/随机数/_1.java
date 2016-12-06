package 随机数;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wushang on 16/7/10.
 */
public class _1 {
    public static void main(String[] args) throws Exception {

        for(int i=0; i<5; ++i) {
            System.out.println((int)(Math.random()*5));
        }
        System.out.println("1---------");
        Random r1 = new Random(5); //如果 种子相同,则生成的数字会相同
        Random r2 = new Random(5);
        Random r3 = new Random( ); //最好以当前系统时间对应的相对时间有关的数字作为种子数

        for(int i=0; i<15; ++i) {
//            System.out.println(r1.nextInt(2));//0 1
//            System.out.println(r2.nextInt(2));
            System.out.println(r3.nextInt(8));
        }

        System.out.println("2--------");
        Map<String, Long> map = new HashMap<>();

        map.put("hello", 3L);
        Long a = map.get("hello");
        a++;
        System.out.println(map.get("hello"));
        System.out.println(a);

        System.out.println("3--------");
        Map<String, String> map2 = new HashMap<>();

        map2.put("hello", "world");
        String b = map2.get("hello");
        b =" boy";
        System.out.println(map2.get("hello"));
        System.out.println(b);

        String str1 = "zhang";
        String str2 = str1;
        str2 = "wang";
        System.out.println(str1);
        System.out.println(str2);

        for(int i=0; i<100; ++i) {
            System.out.println( r3.nextFloat());
        }
    }
}
