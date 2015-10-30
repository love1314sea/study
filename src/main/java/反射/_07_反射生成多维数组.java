package 反射;

import java.lang.reflect.Array;

public class _07_反射生成多维数组 {
    public static void main(String[] args) {
        int[] dims = new int[]{5,10,15};
        //使用 Integer.TYPE ，而不是Integer.Class; 第三个参数是一个可变参数，代表维度的意思，即创建一个三维数组
        Object array = Array.newInstance(Integer.TYPE, dims);

        Object arrayObj = Array.get(array, 3);//获得一个二维数组
        arrayObj = Array.get(arrayObj,4);//获得一个一维数组
        Array.setInt(arrayObj,10,23);//给一维数组第10个元素赋值

        int[][][] arrayCast = (int[][][])array;//强转成三维数组
        System.out.println(arrayCast[3][4][10]);

    }
}
