package netty.demo3.entity;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created by wushang on 16/4/5.
 */
public class MobileCrashRequestMessage {
    @Protobuf(fieldType = FieldType.INT32, order = 1, required = true)
    private int crashId;
    @Protobuf(fieldType = FieldType.STRING, order = 2, required = false)
    private String stack;

    public int getCrashId() {
        return crashId;
    }

    public void setCrashId(int crashId) {
        this.crashId = crashId;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "[crashId=" + crashId + ", stack=" + stack + "]";
    }
}
