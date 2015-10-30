package 类._00_关键字;

// 当final修饰引用类型时，则变量存储的是地址，地址不能替换；但可以替换引用的值
public class _02_final {
    public static void main(String[] args ) {
        B b = new B(4);
        A a = new A();

     //   a.m_b = b; //不能替换，m_b是final类型
        a.m_b.b = 3; // 但可以替换引用类型包含的值
    }
}
class A {
    public final B m_b = new B(2);
}
class B {
    public int b;
    public B(int b) {
        this.b = b;
    }

}