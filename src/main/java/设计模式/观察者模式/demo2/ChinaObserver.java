package 设计模式.观察者模式.demo2;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/3
 */
public class ChinaObserver extends Observer {
    private Subject subject;

    public ChinaObserver(Subject subject) {
        this.subject =subject;
        subject.addObserver(this);//互相引用
    }

    @Override
    public void update() {
        int i = subject.getState();
        if (i == 1) {
            System.out.println("上午好");
        } else if (i == 2) {
            System.out.println("中午好");
        } else if (i == 3) {
            System.out.println("下午好");
        }
    }
}
