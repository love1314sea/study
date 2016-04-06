package Browser.Handler;

/**
 * Created by wushang on 15/11/18.
 */
public interface MessageHandler<T> {
    boolean accept(T message);
    void receive(T message);
}
