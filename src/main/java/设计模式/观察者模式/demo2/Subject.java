package 设计模式.观察者模式.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/3
 */
public class Subject {
    List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState(){
        return state;
    }
    public void setState(int i) {
        if (state == i)
            return;
        state = i;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.stream().forEach(Observer::update);
    }

}
