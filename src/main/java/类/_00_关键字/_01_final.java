package 类._00_关键字;
//final关键字可修饰类（不能被继承)、成员变量(常量）、成员函数（不能被重写）
//当修饰常量时：1 声明时初始化   2 在所有的构造函数中初始化
//一般有final的，都会再用static也修饰。为什么？final是不可改变的，如果每个对象中存储一个占空间，还不如加个static，所有对象共享一份。
public class _01_final {
    public static void main(String[] args) {
        test01 t1 = new test01(4);
        test01 t2 = new test01(5);
        test01 t3 = new test01();
        System.out.println(t1.a);
        System.out.println(t2.a);
        System.out.println(t3.a);
    }
}

class test01 {
    public final int a;
    public test01(){
        a = 0; // 在所有的构造函数中初始化
    }
    public test01(int a) {
        this.a = a; // 在所有的构造函数中初始化
    }
}
class test01_2 {
    public final int a = 3; // 声明时初始化
    public test01_2(){

    }
    public test01_2(int a) {

    }
}




