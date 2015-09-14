package 泛型._01_泛型基础;

/*
对比：MyCollection和StandardCollection
 */


public class _04_实现自己的容器 {
    public static void main(String[] args) {
        MyCollection<Integer> collect = new MyCollection<Integer>();
        for(int i=0; i<10; ++i) {
            collect.add(new Integer(i));
        }
        for(int i=0; i<10; ++i) {
            Integer v = collect.get(i);
            System.out.println(v);
        }
    }
}

class MyCollection<T>{

    private T[] objArr1; //泛型数组
    private int index;

    public MyCollection() {
       this(10); //默认长度为10
    }
    public MyCollection(int capacity) {
        //  objArr1 = new T[capacity]; //错误，java不支持new泛型数组
        objArr1 = (T[])new Object[capacity];//定义成Object[],然后再转换
    }
    public void add(T e) {
        objArr1[index++] = e;
    }
    public T get(int index) {
        return objArr1[index]; //不再需要类型转换
    }
    public int size() {
        return index;
    }
}

class StandardCollection<T> {
    private Object[] objArr2; //直接声明为Object[],而不是泛型
    private int index;

    public StandardCollection(){
        this(10);
    }
    public StandardCollection(int capacity){
        objArr2 = new Object[capacity]; //使用 new Object[]
    }

    public void add(T e) {
        objArr2[index++] = e;
    }
    public T get(int index) {
        return (T)objArr2[index]; //get取出的时候再类型转换
    }
    public int size() {
        return index;
    }
}