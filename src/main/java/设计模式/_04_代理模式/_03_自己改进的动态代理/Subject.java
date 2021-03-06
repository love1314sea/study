package 设计模式._04_代理模式._03_自己改进的动态代理;
/*
抽象角色：声明真实对象和代理对象的共同的接口，为了提供公共的方法
里面的抽象方法，其实是客户端请求的方法。
真实角色继承并重写该方法，是真正要完成的功能。
代理角色继承并重写该方法，是调用真实角色的这个方法
*/

public abstract class Subject {
    public abstract void request();
}
