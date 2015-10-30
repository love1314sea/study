package 设计模式._04_代理模式._01_静态代理;


public class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
