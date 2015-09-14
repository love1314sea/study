package 设计模式.适配器模式.demo1;

/**
类图：http://www.cnblogs.com/java-my-life/archive/2012/04/13/2442795.html
 */
public class Adapter_面向类 extends Person implements Job {

    //实现Job接口，要重写3个类，但是继承了Person类，已经有两个方法。
    @Override
    public void speakFranch() {
        System.out.println("I can speak Franch!");
    }
}
