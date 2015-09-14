package 设计模式.观察者模式.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 15/7/5.
 */
public class PeopleNewsPaper implements INewsPaper {

    private List<ISubScribe> subList = new ArrayList<>();
    @Override
    public void registerSubscriber(ISubScribe f_subScribe) {
        subList.add(f_subScribe);
    }

    @Override
    public void removeSubScriber(ISubScribe f_subScribe) {
        subList.remove(f_subScribe);
    }

    @Override
    public void sendPaper() {
        for(ISubScribe iSubScribe : subList) {
            iSubScribe.HasNewPaper();
        }
    }
}
