package 设计模式._04_代理模式._02_动态代理;

/*
这个和静态代理一样，实现接口，重写函数
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject request");
    }

    public void say(String str) {
        System.out.println("real subject say " + str);
    }
}
