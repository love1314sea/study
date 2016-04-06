package com;

/**
 * Created by wushang on 16/1/8.
 */
public class ExtendDemo extends BaseDemo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) throws Exception{
        BaseDemo baseclass1 = new ExtendDemo();
        BaseDemo baseclass2 = new BaseDemo();
        System.out.println(baseclass1.getClass().getName());// 实际运行的是继承类ExtendDemo
        System.out.println(baseclass2.getClass().getName());// 实际运行的是BaseDemo

        System.out.println(BaseDemo.class.getName());
        System.out.println(ExtendDemo.class.getName());

        System.out.println("Class "+baseclass1.getClass());
        System.out.println("Class "+baseclass2.getClass());

        System.out.println(ExtendDemo.class);

        System.out.println(Class.forName("com.ExtendDemo"));

    }
}