package netty.demo3.entity;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created by wushang on 16/4/5.
 */
public class RequestMessage {
    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    private String requestType;
    @Protobuf(fieldType = FieldType.OBJECT, order = 2, required = false)
    private HotspotRequestMessage hotspotMessage;
    @Protobuf(fieldType = FieldType.OBJECT, order = 3, required = false)
    private MobileCrashRequestMessage mobileCrashMessage;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public HotspotRequestMessage getHotspotMessage() {
        return hotspotMessage;
    }

    public void setHotspotMessage(HotspotRequestMessage hotspotMessage) {
        this.hotspotMessage = hotspotMessage;
    }

    public MobileCrashRequestMessage getMobileCrashMessage() {
        return mobileCrashMessage;
    }

    public void setMobileCrashMessage(MobileCrashRequestMessage mobileCrashMessage) {
        this.mobileCrashMessage = mobileCrashMessage;
    }

    @Override
    public String toString() {
        return "[ requestType=" + requestType + ", hotspotMessage=" + hotspotMessage + ", mobileCrashMessage=" + mobileCrashMessage + "]";
    }
}
