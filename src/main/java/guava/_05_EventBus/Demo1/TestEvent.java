package guava._05_EventBus.Demo1;

/**
 * Created by wushang on 15/10/20.
 */
public class TestEvent {
    private final int message;
    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }
    public int getMessage() {
        return message;
    }
}