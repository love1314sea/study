package Collection.Properties;


public class _02_test {
    public static void main(String[] args) {
        B b = new B();
        b.say();
    }
}
class A {
    void say(){
        System.out.println("hello a");
    }
}

class B extends A {
    /*void say(){
        System.out.println("hello b");
    }*/
}