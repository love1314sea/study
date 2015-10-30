package 设计模式._04_代理模式._02_动态代理;
/*
使用动态代理，被代理的对象（真实角色RealSubject)、需要控制的接口(抽象角色Subject)、控制的方式(代理角色）
都可以动态改变，从而实现了非常灵活的代理关系
 */
/*
动态代理，实际上是使用java用反射做的一个框架
1 代理类要实现InvocationHandler接口，重写invoke方法，构造函数传入Subject的实现类对象
2 客户端使用Proxy.newProxyInstance(...) 创建代理，并通过代理调用函数
3 执行逻辑：执行subject.request()时，肯定调用了InvocationHandler handler，并传递了method对象
  和参数，里面封装了大量的逻辑

 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();//一定是Subject的实现类对象

        InvocationHandler handler = new ProxySubject(realSubject);
        Class<?> classType = handler.getClass();
        //下一行的代码 一次性生成代理实例
        //第一个参数,获得getClassLoader，可以使用任意的类或对象来获得加载器
        //第二个参数，获得真实角色所实现的所有接口
        //第三个参数，一个代理角色的对象，时InvocationHandler类型（实现了这个接口），最终会调用这个对象的invoke方法
        Subject subject = (Subject) Proxy.newProxyInstance(classType.getClassLoader(),
                realSubject.getClass().getInterfaces(),handler);

        subject.request();
        subject.say("hello");//传入参数
        System.out.println(subject.getClass());//可以看出这是动态生成的类，并实现了参数中realSubject.getClass().getInterfaces()接口

    }
}
