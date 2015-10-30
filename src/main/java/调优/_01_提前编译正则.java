package 调优;
//优化：http://www.techug.com/linkedin-feed-faster-less-jvm-garbage

import java.util.regex.Pattern;

public class _01_提前编译正则 {
    //优化前：直接使用正则替换
    private static String transform_1(String term) {
        return term.replaceAll("my\\d+", "abc");
    }

    //优化后：先提前编译正则，再替换
    private final static Pattern _pattern = Pattern.compile("my\\d+");//先
    private static String transform_2(String term) {
        return  _pattern.matcher(term).replaceAll("abc");
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        for(int i=0;i<10000; ++i)
            transform_1("hello my123 zhonggguo");
        System.out.println(System.currentTimeMillis());
        for(int i=0;i<10000; ++i)
            transform_2("hello my123 zhonggguo");
        System.out.println(System.currentTimeMillis());
    }
}
