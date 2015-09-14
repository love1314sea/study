package 泛型._04_实现泛型接口;


public interface Parent<T1,T2> {
    public T1 getFoo1(T1 foo1);
    public void setFoo1(T1 foo1);

    public T2 getFoo2(T2 foo2);
    public void setFoo2(T2 foo2);
}
