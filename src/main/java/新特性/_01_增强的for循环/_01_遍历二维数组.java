package 新特性._01_增强的for循环;


public class _01_遍历二维数组 {
    public static void main(String[] args){
        int[][] arr = new int[][]{{1,2,3},{4,5},{7,8,9}};

        for(int[] list: arr){
            for(int ele: list){
                System.out.println(ele);
            }
        }
    }
}
