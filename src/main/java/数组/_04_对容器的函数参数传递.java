package 数组;



import java.util.ArrayList;
import java.util.List;

public class _04_对容器的函数参数传递 {
    //函数中操作list会对原来的造成影响，而不是返回一个新的
    public static void addTest(List<String> list) {
        list.add("ccc");
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        for(String s: list)
            System.out.println(s);
        System.out.println("------------");
        addTest(list); //
        for(String s: list)
            System.out.println(s);
    }
}
