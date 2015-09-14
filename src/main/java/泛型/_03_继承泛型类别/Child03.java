package 泛型._03_继承泛型类别;
/*
1 父类有泛型，子类必须也有相应的泛型
2 生成对象时，子类参数化，相应的也就参数化了父类的泛型
 */
// public class Child03 <T3> extends Parent03< T1, T2 >{ //子类无T1 T2,则报错
public class Child03< T1, T2, T3 > extends Parent03< T1, T2 >{

    private T3 foo3;

    public T3 getFoo3() {
        return foo3;
    }

    public void setFoo3(T3 foo3) {
        this.foo3 = foo3;
    }
}
