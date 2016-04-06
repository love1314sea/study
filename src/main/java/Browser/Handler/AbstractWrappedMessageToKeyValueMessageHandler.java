package Browser.Handler;


/**
 * Created by wushang on 15/11/19.
 */
public abstract class AbstractWrappedMessageToKeyValueMessageHandler<T> implements MessageHandler<T>{


    @Override
    public void receive(T message) {
        System.out.println("AbstractWrappedMessageToKeyValueMessageHandler receive");
    }

    protected String buildAggregateKey(T message) {
        System.out.println("AbstractWrappedMessageToKeyValueMessageHandler buildkey");
        return "key";
    }
    protected String buildAggregateValues(T message) {
        System.out.println("AbstractWrappedMessageToKeyValueMessageHandler buildvalues");
        return "values";
    }
}
