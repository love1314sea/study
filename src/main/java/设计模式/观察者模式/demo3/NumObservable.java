package 设计模式.观察者模式.demo3;

import java.util.Observable;

/**
 * Created by wushang on 15/7/6.
 */
public class NumObservable extends Observable {
    private int data = 0;
    public int getData() {
        return data;
    }
    public void setData(int i) {
        data = i;

        //监控data的变化
        setChanged();
        notifyObservers();//也可以有参数
    }
}
