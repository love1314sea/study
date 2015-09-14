package 泛型._01_泛型基础;


public class _05_泛型的泛型 {
    public static void main(String[] args) {
        GenericFoo5<String> foo = new GenericFoo5<String>();
        foo.setFoo("boy");

        WrapFoo<String> wrapFoo = new WrapFoo<String>();
        wrapFoo.setFoo(foo);

        GenericFoo5<String> g  = wrapFoo.getFoo();
        System.out.println(g.getFoo());
    }
}
class WrapFoo<T> {
    private GenericFoo5<T> foo;  //包含泛型类的成员变量

    public GenericFoo5<T> getFoo() {
        return foo;
    }

    public void setFoo(GenericFoo5<T> foo) {
        this.foo = foo;
    }
}
class GenericFoo5<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
}
