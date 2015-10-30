package 设计模式._04_代理模式._04_动态代理;


import 设计模式._04_代理模式._02_动态代理.ProxySubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler{
    private Object object;
    public VectorProxy(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call:" + method);
        if(args != null) {
            for(Object obj : args) {
                System.out.println("para :" + obj);
            }
        }
        Object ret = method.invoke(object,args);
        System.out.println("after call:" + method);
        return ret;
    }
    //以上完成的是代理角色，基本不变；
    //
    public static Object factory(Object object){//传入的参数肯定是真实角色的对象
        Class<?> classType = object.getClass();
        //由真实角色的对象获得类加载器和它实现哪些接口，方便后面动态构建类和它的实例
        return Proxy.newProxyInstance(classType.getClassLoader(),classType.getInterfaces(),new VectorProxy(object));
    }

    public static void main(String[] args) throws Exception{
        List list1 = new ArrayList<>();
        System.out.println(list1.getClass().getName());//java.util.ArrayList
        /*
        虽然都是List对象，但二者是不同的。下面的是动态生成的，List接口相当于抽象对象，真实对象Vector实现了List
        ，在classType.getInterfaces()中能获得这个接口，因此能够强制转换
         */
        List v = (List)factory(new Vector());
        System.out.println(v.getClass().getName());//com.sun.proxy.$Proxy0

        v.add("wu");
        v.add("shang");

        System.out.println(v); //调用toString方法，并返回字符串

        v.remove(0);


    }
}
