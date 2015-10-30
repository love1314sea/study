package 数组;
/*
java中没有指针，只有通过数组的方式来交换
 */
public class _03_交换 {
    public static void swap1(int[] arr) {
        int t = arr[0];
        arr[0] = arr[1];
        arr[1] = t;
    }
    public static void swap2(int[] arr) {
        arr[1] = arr[0] + arr[1];
        arr[0] = arr[1] - arr[0];
        arr[1] = arr[1] - arr[0];
    }
    public static void main(String[] args){
        int[] arr = {1,2};
        swap1(arr);
        System.out.println(arr[0]+":"+arr[1]);
    }
}
