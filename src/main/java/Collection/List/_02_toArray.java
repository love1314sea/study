package Collection.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 15/11/20.
 */
/*
由List转换成固定长度的数组，可通过参数传入得到结果，也可通过返回值
 */
public class _02_toArray {

    public static Integer[] vectorToArray1(ArrayList<Integer> v) {
        Integer[] newText = new Integer[v.size()];
        v.toArray(newText);
        return newText;
    }
    public static Integer[] vectorToArray2(List<Integer> v) {
        Integer[] newText = v.toArray(new Integer[0]);
        return newText;
    }
    public static Integer[] vectorToArray3(List<Integer> v) {
        Integer[] newText = new Integer[v.size()+5];
        newText[11] = 111;
        Integer[] newStrings = v.toArray(newText);
        return newStrings;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10; ++i) {
            list.add(i);
        }
// 不带参数的toArray,返回的是Object[],转换会报错
//        Integer[] arr = (Integer[])list.toArray();

        Integer[] results = vectorToArray3(list);
        for(Integer i: results) {
            System.out.println(i);
        }

    }
}
