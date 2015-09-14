package 泛型._03_继承泛型类别;


public class Parent03<T1, T2> {
    private T1 foo1; //属性私有，无法继承
    private T2 foo2;

    public T1 getFoo1() {
        return foo1;
    }

    public void setFoo1(T1 foo1) {
        this.foo1 = foo1;
    }

    public T2 getFoo2() {
        return foo2;
    }

    public void setFoo2(T2 foo2) {
        this.foo2 = foo2;
    }
}
