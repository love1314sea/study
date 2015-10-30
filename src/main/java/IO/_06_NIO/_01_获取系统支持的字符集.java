package IO._06_NIO;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

//只要使用Charset类的availableCharsets() 函数
public class _01_获取系统支持的字符集 {
    public static void main(String[] args) {
        SortedMap<String,Charset> map = Charset.availableCharsets();
        Set<String> set = map.keySet();
        for(Iterator<String> iter = set.iterator();iter.hasNext();){
            System.out.println(iter.next());
        }
    }
}
