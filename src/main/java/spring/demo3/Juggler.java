package spring.demo3;

/**
 * Created by wushang on 15/10/21.
 */
public class Juggler implements Performer {
    private int bagBeans = 3;

    public Juggler() {

    }
    public Juggler(int bagBeans) {
        this.bagBeans = bagBeans;
    }

    public void setBagBeans(int bagBeans) {
        this.bagBeans = bagBeans;
    }

    @Override
    public void perform() throws Exception {
        System.out.println("JUGGLing " + bagBeans + " bags");
    }
}
