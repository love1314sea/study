package 设计模式.观察者模式.demo2;

/**
 * Created by wushang on 15/7/5.
 */
public class Main {
    public static void main(String[] args) {
        ISubScribe subScribe1 = new SubHuman("zhang san");
        ISubScribe subScribe2 = new SubHuman("li si");
        ISubScribe subScribe3 = new SubHuman("wang wu");

        INewsPaper iNewsPaper = new PeopleNewsPaper();
        iNewsPaper.registerSubscriber(subScribe1);
        iNewsPaper.registerSubscriber(subScribe2);
        iNewsPaper.registerSubscriber(subScribe3);

        iNewsPaper.sendPaper();

        iNewsPaper.removeSubScriber(subScribe1); //zhang san 取消报纸
        iNewsPaper.sendPaper();
    }
}
