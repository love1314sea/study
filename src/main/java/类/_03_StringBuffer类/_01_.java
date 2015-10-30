package 类._03_StringBuffer类;

//StringBuffer生成的对象时可变的
public class _01_ {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello").append(100).append(3.14);//append重载了很多
        System.out.println(sb);
        String str = sb.toString();//把可变的StringBuffer转换成常量形式的String
        System.out.println(str);

        int a = 4;
        String s = "hello";
        boolean b = false;
        String s2 = s + a + b; //String也可以各个类型相加再转换
        System.out.println(s2);
    }
}
