package 泛型._02_泛型对象通配声明;
/*
1 如果<? extends Object>可简写为<?>
2 ...
 */

import java.util.Objects;

public class _02_通配 {
    public static void main(String[] args) {
        GenericTest2<String> ge = new GenericTest2<>();
        ge.setFoo("hello");
        ge.setFoo("woo"); //能够重新赋值


/*
使用<?>或<? extends someclass>的声明方式，一经赋值，意味着只能通过该名称取得所参考实例的信息，或移除某些信息(设置为null）
而不能增加(更改）它的信息。
因为只知道当中放置的是someclass的子类，但不确定是什么类的实例,编译器不让你加入信息。
理由是：泛型是为了防止取出时的类型转换。如果加入信息的话，取回实例时就必须记得是什么类型，然后
转换为原来的类型方可进行操作，但这失去了使用泛型的意义。
 */
        GenericTest2<? extends Object> ge2 = ge;
        GenericTest2<?> ge4 = ge; //如果<? extends Object>可简写为<?>，方式同上
        System.out.println(ge2.getFoo());
        ge2.setFoo(null);
        System.out.println(ge2.getFoo());
      //  ge2.setFoo("wo"); //只能取得不能够重新赋值

    }
}
class GenericTest2<T> { //声明类时，并不extends
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
}