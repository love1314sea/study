package 设计模式.观察者模式.demo3;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wushang on 15/7/6.
 */
public class NumObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        NumObservable myObserable=(NumObservable) o;
        System.out.println("Data has changed to " + myObserable.getData());
    }
}
