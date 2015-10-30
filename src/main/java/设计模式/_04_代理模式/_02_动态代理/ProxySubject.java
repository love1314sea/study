package 设计模式._04_代理模式._02_动态代理;

/*
1 代理类需要实现InvocationHandler接口，但不用实现原来的代理接口了。
2 构造函数是一个Object对象，构造的时候传入Subject接口的实现类
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler{
    //为什么是Object，这样可以传入Subject接口的任意实现类的对象了，这是对静态代理改进的地方
    private Object sub;//实际上仍然是真实角色的对象
    public ProxySubject(Object object) {
        this.sub = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin----------:" + method);
        method.invoke(sub, args);//注意sub参数，指的是调用这个对象的方法
        System.out.println("end------------:" + method);
        return null;
    }
}
