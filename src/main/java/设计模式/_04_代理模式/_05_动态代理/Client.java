package 设计模式._04_代理模式._05_动态代理;


import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Foo f = null;

        CommonInvocationHandler handler = new CommonInvocationHandler();
        handler.setObject(new FooImpl1());//用真实角色FooImpl1,使用哪个真实角色的函数，取决于传入哪个真实角色的对象
        f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class}, handler);
        f.doAction();
        System.out.println("------------------");
        handler.setObject(new FooImpl2());//用真实角色FooImpl2
        f = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class}, handler);
        f.doAction();
    }
}
