package 新特性._02_可变参数;
/*
1 只能接受一个可变参数
2 必须放最后
 */

public class _02_VarArgs放最后 {
    public static int sum(String s, int... nums) {//可变参数必须放最后
        System.out.println(s);
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sum("hello",1,2,3));
        System.out.println(sum("hello",1,2,3,4));

        System.out.println( sum("hello",new int[]{1,2,3}) ); //传递数组
    }
}

