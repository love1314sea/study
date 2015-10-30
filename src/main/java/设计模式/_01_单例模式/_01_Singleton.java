package 设计模式._01_单例模式;

/*
单例模式，即一个实例。
1 保证一个实例，首先，构造函数设置成private
2 返回一个实例的函数，因为不能使用对象调用，因此使用static修饰，可以使用类调用
3 保证只返回唯一的一个实例。静态函数调用成员变量，成员变量也必须是static的。
 */
public class _01_Singleton {
    public static void main(String[] args) {
        Singleton s1 =  Singleton.getInstance();
        Singleton s2 =  Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
class Singleton{
    private static Singleton singleton = new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance() {
        return singleton;
    }
}