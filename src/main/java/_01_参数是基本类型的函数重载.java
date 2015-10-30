/*
目的：测试参数是基本类型的函数重载
1 即原始类型不能自动向“窄”的类型转换,必须强制成其他类型
2 可以自动向宽类型转换
3 byte->short->int->long->float->double
4 char->int
 */
public class _01_参数是基本类型的函数重载 {

    /*public void f1(char x) {
        System.out.println("f1(char)");
    }*/
    public void f1(byte x) {
        System.out.println("f1(byte)");
    }
    /*public void f1(int x) {
        System.out.println("f1(int)");
    }*/
    public void f1(long x) {
        System.out.println("f1(long)");
    }
    public void f1(float x) {
        System.out.println("f1(float)");
    }
    public static void main(String[] args) {
        _01_参数是基本类型的函数重载 test = new _01_参数是基本类型的函数重载();
        test.f1((int)0.5);//0.5是double类型，必须强制成其他类型；即原始类型不能自动向“窄”的类型转换
        test.f1(8);//8是int类型，可以自动向宽类型转换，

        char c = '5';
        test.f1(c); //char类型特殊：自动转换成int
    }
}

