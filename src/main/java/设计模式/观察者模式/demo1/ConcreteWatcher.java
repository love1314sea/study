package 设计模式.观察者模式.demo1;

public class ConcreteWatcher implements Watcher {

    @Override
    public void update(String str) {
        System.out.println(str);
    }

}