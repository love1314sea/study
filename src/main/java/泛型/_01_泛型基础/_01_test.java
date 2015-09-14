package 泛型._01_泛型基础;

/*
为什么引入泛型？ 尽可能让程序在编译期间报错，而不是在运行期间。
泛型是变量类型的参数化。
1 在容器中必须使用泛型
2 使用泛型，如果代码编译不出现警告，则运行时就不会出现ClassCastException错误
3 有泛型的接口、类在实现接口或实例化对象时必须要告诉它是什么类型，否则，默认为是Object类型
 */
public class _01_test {
    public static void main(String[] args) {
        GenericFoo<Boolean> foo1 = new GenericFoo<Boolean>();
        foo1.setFoo(new Boolean(true)); //只能放Boolean类型
        Boolean f1 = foo1.getFoo(); // 不需要使用类型转换，避免了语法错误；只能给Boolean赋值，在编译器间就能检查出这个错误

        GenericFoo<Integer> foo2 = new GenericFoo<Integer>();
        foo2.setFoo(new Integer(10));
        //String f3 = (String)foo2.getFoo();  //能检查出语法错误
        Integer f2 = foo2.getFoo();
    }
}
class GenericFoo<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
}
