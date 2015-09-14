package 泛型._01_泛型基础;

/*
限制泛型类别，只能用某个特定类型或者其子类型才能实例化该类型
泛型中使用extends关键字制定传入的类型必须继承某个类或实现某个接口
 */

import java.util.ArrayList;
import java.util.List;

public class _06_限制泛型的可用类型 {
    public static void main(String[] args) {
        ListGenericFoo5<ArrayList<String>> foo1 = new ListGenericFoo5<>();
        ArrayList<String>[] arrayList = new ArrayList[5];
        foo1.setFooArray(arrayList);

     //   ListGenericFoo5<HashMap> foo2 = new ListGenericFoo5<>(); //错误
    }
}

class ListGenericFoo5<T extends List> { //无论是类还是接口都使用extends
    private T[] fooArray;

    public T[] getFooArray() {
        return fooArray;
    }

    public void setFooArray(T[] fooArray) {
        this.fooArray = fooArray;
    }
}
