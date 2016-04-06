package Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wushang on 15/7/14.
 */
public class _1 {
    public void change(String s) {
        s = s+ " _bak";
    }
    public void change(Student s) {
        s.setName("zhang");
    }

    public void exe(String s){
        System.out.println(s);
        change(s);
        System.out.println(s);
    }

    public void exe(Student s){
        System.out.println(s);
        change(s);
        System.out.println(s);
    }
    public static void main(String[] args) {
        new _1().exe("hello");

        Student s = new Student();
        s.setName("li");
        s.setAge(20);
        new _1().exe(s);

        List<String> list = new ArrayList<>();
        list.add("3");
//        list.r

    }
}

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + ", age:" + age;
    }
}
