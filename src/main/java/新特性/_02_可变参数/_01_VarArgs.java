package 新特性._02_可变参数;
/*
可变参数的本质是一个数组，因此传参可以是离散的值，也可以是数组,可以为空
 */

public class _01_VarArgs {
    public static int sum(int... nums) {//函数的可变参数
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sum(1,2,3));
        System.out.println(sum(1,2,3,4));

        System.out.println( sum(new int[]{1,2,3}) ); //传递数组
    }
}
