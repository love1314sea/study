package Browser;

import Browser.Handler.BrowserApplicationStatMessageHandler;
import Browser.Handler.MessageHandler;
import Browser.Handler.PageWrappedMessageToApplicaitonOverviewBinKeyValueMessageHandler;
import Browser.WrappedMessage.BrowserAjaxWrappedMessage;
import Browser.WrappedMessage.BrowserJsErrorsWrappedMessage;
import Browser.WrappedMessage.WrappedMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 15/11/18.
 */
public class Main {
    List<WrappedMessage> messages;
    List<MessageHandler> handlers;

    public List<WrappedMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<WrappedMessage> messages) {
        this.messages = messages;
    }

    public List<MessageHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<MessageHandler> handlers) {
        this.handlers = handlers;
    }

    public static void main(String[] args) {
//        List<WrappedMessage> messages = new ArrayList<>();
//        messages.add(new BrowserAjaxWrappedMessage());
//        messages.add(new BrowserJsErrorsWrappedMessage());
//
//        List<MessageHandler> handlers = new ArrayList<>();
////        handlers.add(new BrowserApplicationStatMessageHandler());
//        handlers.add(new PageWrappedMessageToApplicaitonOverviewBinKeyValueMessageHandler());

        ApplicationContext context = new ClassPathXmlApplicationContext("/browser.xml");
        Main main = (Main)context.getBean("main");
        for(WrappedMessage message: main.messages) {
            for(MessageHandler handler: main.handlers) {
                if(handler.accept(message)) {
                    handler.receive(message);
                }
            }
        }

    }
}
