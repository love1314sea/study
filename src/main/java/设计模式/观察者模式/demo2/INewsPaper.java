package 设计模式.观察者模式.demo2;

public interface INewsPaper {
    //添加订阅者
    void registerSubscriber(ISubScribe f_subScribe);

    //取消订阅
    void removeSubScriber(ISubScribe f_subScribe);

    //发送报纸
    void sendPaper();
}