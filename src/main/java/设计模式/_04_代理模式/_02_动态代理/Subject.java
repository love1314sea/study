package 设计模式._04_代理模式._02_动态代理;

/*
必须是接口，因为Client端Proxy.newProxyInstance第2个参数传递的是接口类型
并定义所有需要代理调用的防范
 */
public interface Subject {
    void request();
    void say(String str);
}
