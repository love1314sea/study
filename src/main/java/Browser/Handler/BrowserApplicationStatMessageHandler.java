package Browser.Handler;

import Browser.KeyValueMessage.AggregateKeyValues;

/**
 * Created by wushang on 15/11/18.
 */
public class BrowserApplicationStatMessageHandler <T extends AggregateKeyValues> extends AbstractWrappedMessageToKeyValueMessageHandler<T> {
    @Override
    public boolean accept(T message) {
        System.out.println("BrowserApplicationStatMessageHandler accept");
        return false;
    }

    @Override
    public void receive(T message) {
        System.out.println("BrowserApplicationStatMessageHandler receive");
        String key = this.buildAggregateKey(message);
        String value = this.buildAggregateValues(message);
    }
}
