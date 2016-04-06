package 容器.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wushang on 15/11/20.
 */
/*
容器的trimToSize方法，就是copyOf实现的
数组的拷贝最终调用的是System.arrayCopy()
 */
public class _01_copyOf {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] arr = new Integer[5];
        System.out.println(arr.length);//长度为5

        arr = Arrays.copyOf(list.toArray(new Integer[0]),list.size()); //返回一个新的数组，赋值
        System.out.println(arr.length); //长度为3

    }
}
