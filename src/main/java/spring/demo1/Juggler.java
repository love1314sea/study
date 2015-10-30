package spring.demo1;

/**
 * Created by wushang on 15/10/21.
 */
public class Juggler implements Performer {
    private int beanBags = 3;
    public Juggler() {

    }
    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }
    @Override
    public void perform() throws Exception {
        System.out.println("JUGGLER:" + beanBags + " bags");
    }
}
