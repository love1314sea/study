package 数组;


public class _02_二维数组定义和遍历 {
    public static void main(String[] args) {
        /*int[][] arr = new int[3][]; //每行的元素个数可以不同
        arr[0] = new int[2];//第一行2个元素
        arr[1] = new int[3];//第二行3个元素
        arr[2] = new int[1];//第三行1个元素*/

        int[][] arr = {{1,2,3},{4,5},{6}};
        for(int i=0; i<arr.length;++i){
            for(int j=0; j<arr[i].length; ++j){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
