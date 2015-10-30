package 类._04_包装类;
/*
为什么会有包装类？
8种基本类型到引用类型的转换
 */

public class _01_Integer {
    public static void main(String[] args){
        Integer t1 = new Integer(200); //包装，
        int t2 = t1.intValue();//解包装
        System.out.println(t1+":"+ t2);

        int t3 = Integer.parseInt("123");
        Integer t4 = Integer.valueOf("123");

        byte b = 4;
        Byte b1 = new Byte(b);
        byte b2 = b1.byteValue();
        System.out.println(b1+":"+b2);
    }
}

