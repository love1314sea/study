package 类._00_关键字;


public class _01_static代码块 {
    public static void main(String[] args ) {
        new Sub_Test01();
        new Sub_Test01();
    }
}

class Test01 {
    static {
        System.out.println("Test01 static");//静态代码块是在jvm加载类的时候执行
    }                         //而构造函数是在构造对象的时候执行，静态代码块要比构造函数要早
    public Test01(){
        System.out.println("test01");
    }
}

class Sub_Test01 extends Test01 {
    static {
        System.out.println("Test02 static");
    }
    public Sub_Test01(){
        System.out.println("test02");
    }
}
