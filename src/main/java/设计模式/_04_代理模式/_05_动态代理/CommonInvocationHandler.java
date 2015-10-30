package 设计模式._04_代理模式._05_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHandler implements InvocationHandler {
    private Object object;
    public CommonInvocationHandler() {

    }
    public CommonInvocationHandler(Object object){
        this.object = object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object, args);
        return null;
    }
}
