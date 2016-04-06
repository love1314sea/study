package netty.demo3.entity;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created by wushang on 16/4/5.
 */
public class HotspotRequestMessage {
    @Protobuf(fieldType = FieldType.INT32, order = 1, required = true)
    private int appId;
    @Protobuf(fieldType = FieldType.STRING, order = 2, required = false)
    private String version;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "[appId=" + appId + ", version=" + version + "]";
    }
}
