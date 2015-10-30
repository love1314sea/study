package spring.demo1;

/**
 * Created by wushang on 15/10/21.
 */
public class Player implements Performer {
    @Override
    public void perform() throws Exception {
        System.out.println("Player: play");
    }
}
