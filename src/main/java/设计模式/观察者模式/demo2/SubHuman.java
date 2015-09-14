package 设计模式.观察者模式.demo2;

/**
 * Created by wushang on 15/7/5.
 */
public class SubHuman implements ISubScribe{
    private String name;
    public SubHuman(String name) {
        this.name = name;
    }
    @Override
    public void HasNewPaper() {
        System.out.println(name + "!! 有新的报纸了，请查收！");
    }
}
