package 类._02_String类;

//String类无论哪种方式生成对象，都是一个常量；要想使用变量，使用StringBuffer类
public class _01_intern {
    public static void main(String[] args ){
        String s1 = "aaa";//字面值常量方式创建，在栈中，StringPool中创建
        String s2 = new String("aaa");//在堆中创建
        String s3 = new String("aaa").intern();//intern()方法，拘禁到StringPool中
        System.out.println(s1 == s2);//flase
        System.out.println(s1 == s3);//true
        System.out.println(s2 == s3);//false
    }
}
