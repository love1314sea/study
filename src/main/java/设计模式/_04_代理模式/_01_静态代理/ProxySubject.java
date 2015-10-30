package 设计模式._04_代理模式._01_静态代理;
/*
代理角色：含有对真实对象的引用，从而可操作真实对象; 同时也可以附加自己的操作
 */

public class ProxySubject extends Subject{
    private RealSubject realSubject; //含有对真实对象的引用


    @Override
    public void request() {

        if(realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();//完成自己的操作
        realSubject.request();//调用真实对象的操作
        postRequest();
    }

    private void preRequest() {
        System.out.println("pre request");
    }
    private void postRequest() {
        System.out.println("post request");
    }
}
