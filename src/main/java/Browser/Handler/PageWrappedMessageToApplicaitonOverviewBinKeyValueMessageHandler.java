package Browser.Handler;

import Browser.WrappedMessage.WrappedMessage;

/**
 * Created by wushang on 15/11/18.
 */
public class PageWrappedMessageToApplicaitonOverviewBinKeyValueMessageHandler<T extends WrappedMessage> extends AbstractWrappedMessageToKeyValueMessageHandler<T> {
    @Override
    public boolean accept(T message) {
        System.out.println("PageWrappedMessageToApplicaitonOverviewBinKeyValueMessageHandler accept");
        return false;
    }

    @Override
    public void receive(T message) {
        System.out.println("PageWrappedMessageToApplicai    tonOverviewBinKeyValueMessageHandler receive");
    }
}
