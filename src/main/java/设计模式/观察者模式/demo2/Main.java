package 设计模式.观察者模式.demo2;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/3
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new ChinaObserver(subject);

        subject.setState(1);
    }
}
