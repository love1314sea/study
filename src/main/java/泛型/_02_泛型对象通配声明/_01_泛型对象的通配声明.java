package 泛型._02_泛型对象通配声明;
/*
1 泛型对象的通配声明,声明类时，并不extends
而是在 生成对象时，使用 <？entends ..>通配，可以给赋值不同的实现类,只要它继承了后面的接口
2 另外可以使用super，则必须是后面类型的上一层
 */

import java.util.*;

public class _01_泛型对象的通配声明 {
    public static void main(String[] args) {
        GenericTest1<? extends List> ge = null; //生成对象时，使用 ？通配，继承了List接口即可
        ge = new GenericTest1<ArrayList>();
        ge = new GenericTest1<LinkedList>(); //可以给赋值不同List的实现类
      //  ge = new GenericTest1<HashMap>(); //错误

        GenericTest1<? super List> ge2 = null;
       // ge2 = new GenericTest1<ArrayList>(); //错误
        ge2 = new GenericTest1<Object>();
        ge2 = new GenericTest1<Collection>();
    }
}

class GenericTest1<T> { //声明类时，并不extends
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
}