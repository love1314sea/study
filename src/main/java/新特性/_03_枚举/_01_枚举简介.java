package 新特性._03_枚举;
/*
关键字enum
1 枚举本质是一个类，继承自java.lang.Enum，每个成员默认为是public static final类型
2 每个枚举的成员其实就是枚举类型的一个实例(Instance). 在编译期间确定。
 */

enum Color{
    RED,BLACK,WHITE
}
public class _01_枚举简介 {
    public static void main(String[] args){
        Color color = Color.BLACK;
        System.out.println(color);
        for(Color c : Color.values()) { //枚举的遍历
            System.out.println("--" + c);
        }
    }
}
