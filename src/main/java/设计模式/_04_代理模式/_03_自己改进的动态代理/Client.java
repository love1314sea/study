package 设计模式._04_代理模式._03_自己改进的动态代理;

/*
依据动态代理改进。如果Subject有多个实现类，那么代理类中对真实对象的引用变为Subjec类，
构造函数中传入调用哪个实现类的方法。
 */

public class Client {
    public static void main(String[] args) {
    /*    Subject subject = new ProxySubject();
        subject.request();*/

        ProxySubject proxySubject = new ProxySubject(new RealSubject2());
        proxySubject.request();
    }
}
