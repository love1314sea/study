package netty.demo3;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import netty.demo3.entity.MobileCrashRequestMessage;
import netty.demo3.entity.RequestMessage;

/**
 * Created by wushang on 16/3/31.
 */
public class ProtobufClientHandler extends ChannelHandlerAdapter {
//    private final static String DELIMITER = System.getProperty("line.separator");
    private final static String DELIMITER = "$_";
    private final static ByteBuf DELIMITER_BUF;
    private final static Codec<RequestMessage> simpleTypeCodec = ProtobufProxy.create(RequestMessage.class);

    static {
        DELIMITER_BUF = Unpooled.buffer(DELIMITER.getBytes().length);
        DELIMITER_BUF.writeBytes(DELIMITER.getBytes());
    }
    //    private final ByteBuf firstMessage;
//
//    public TimeClientHandler() {
//        byte[] req = "QUERY TIME ORDER".getBytes();
//        firstMessage = Unpooled.buffer(req.length);//生成ByteBuf对象
//        firstMessage.writeBytes(req);
//    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

//        for (int i = 0; i < 5; ++i) {
//            byte[] req = ("QUERY TIME ORDER" + DELIMITER).getBytes();
//            ByteBuf firstMessage = Unpooled.buffer(req.length);
//            firstMessage.writeBytes(req);
//
//            ctx.writeAndFlush(firstMessage);
//            System.out.println(firstMessage.readableBytes());
//        }

//        for (int i = 0; i < 5; ++i) {
            RequestMessage message = new RequestMessage();
            message.setRequestType("hotspot");
            MobileCrashRequestMessage crashMessage = new MobileCrashRequestMessage();
            crashMessage.setCrashId(100);
            crashMessage.setStack("stack");
            message.setMobileCrashMessage(crashMessage);

            byte[] cc = simpleTypeCodec.encode(message);
            byte[] res = new byte[cc.length + DELIMITER.getBytes().length];
            byte[] delis =  DELIMITER.getBytes();
            System.arraycopy(cc,0,res,0,cc.length);
            System.arraycopy(delis, 0, res, cc.length, delis.length);
            ByteBuf firstMessage = Unpooled.buffer(res.length);
            firstMessage.writeBytes(res);

            ctx.writeAndFlush(firstMessage);
//        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Now is :" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private static int indexOf(ByteBuf haystack, ByteBuf needle) {
        for (int i = haystack.readerIndex(); i < haystack.writerIndex(); i ++) {
            int haystackIndex = i;
            int needleIndex;
            for (needleIndex = 0; needleIndex < needle.capacity(); needleIndex ++) {
                if (haystack.getByte(haystackIndex) != needle.getByte(needleIndex)) {
                    break;
                } else {
                    haystackIndex ++;
                    if (haystackIndex == haystack.writerIndex() &&
                            needleIndex != needle.capacity() - 1) {
                        return -1;
                    }
                }
            }

            if (needleIndex == needle.capacity()) {
                // Found the needle from the haystack!
                return i - haystack.readerIndex();
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        RequestMessage message = new RequestMessage();
        message.setRequestType("hotspot");
        MobileCrashRequestMessage crashMessage = new MobileCrashRequestMessage();
        crashMessage.setCrashId(100);
        crashMessage.setStack("stack");
        message.setMobileCrashMessage(crashMessage);

        Codec<RequestMessage> simpleTypeCodec = ProtobufProxy.create(RequestMessage.class);
        byte[] cc = simpleTypeCodec.encode(message);
        System.out.println("cc lenght=" + cc.length);
        byte[] res = new byte[cc.length + DELIMITER.getBytes().length];
        byte[] delis =  DELIMITER.getBytes();
        System.out.println("res length=" + res.length);
        System.arraycopy(cc,0,res,0,cc.length);
        System.arraycopy(delis, 0, res, cc.length, delis.length);
        ByteBuf firstMessage = Unpooled.buffer(res.length);
        firstMessage.writeBytes(res);

//        ByteBuf firstMessage = Unpooled.buffer(cc.length);
//        firstMessage.writeBytes(cc);
//        }

        indexOf(firstMessage, DELIMITER_BUF);
    }
}
