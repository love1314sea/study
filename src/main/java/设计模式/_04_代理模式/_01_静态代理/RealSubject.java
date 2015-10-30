package 设计模式._04_代理模式._01_静态代理;
/*
真实角色：是我们最终要引用的对象，要调用的方法
 */

public class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
