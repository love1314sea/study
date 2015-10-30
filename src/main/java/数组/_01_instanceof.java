package 数组;

//instancof来测试它所指向的对象是否是某类的一个实例，
public class _01_instanceof {

    public static void main(String[] args ){
        int[][] arr = new int[2][3];
        System.out.println(arr instanceof Object);
        System.out.println(arr[0] instanceof int[]);//arr[0]是一维数组
        System.out.println(arr[0] instanceof Object);
    }
}
