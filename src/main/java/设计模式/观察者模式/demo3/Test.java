package 设计模式.观察者模式.demo3;

/**
参考：http://zhangjunhd.blog.51cto.com/113473/68949/
 */
public class Test {
    public static void main(String[] args) {
        NumObservable number = new NumObservable();
        number.addObserver(new NumObserver());
        number.addObserver(new NumObserver());

        number.setData(1);
        number.setData(2);

    }
}
