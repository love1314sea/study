package netty.demo3;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import netty.demo3.entity.RequestMessage;
import protobuf.demo2.SimpleTypeTest;

import java.util.Date;

/**
 * Created by wushang on 16/2/17.
 */
public class ProtobufServerHandler extends ChannelHandlerAdapter {

//     the channelActive() method will be invoked when a connection is established and ready to generate traffic
    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture future) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                assert f == future;
//                System.out.println("close---");
//                ctx.close();
//            }
//        }); // (4)
//        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        System.out.println("length="+bytes.length);
        Codec<RequestMessage> simpleTypeCodec = ProtobufProxy.create(RequestMessage.class);
        RequestMessage message = simpleTypeCodec.decode(bytes);
        System.out.println(message);
        System.out.println(message.getMobileCrashMessage());
        System.out.println("yes");

//        System.out.println("The time server receive body:" + body);
//        String currentTime = "BAD ORDER";
//        if ("QUERY TIME ORDER".equals(body)) {
//            currentTime = new Date(System.currentTimeMillis()).toString();
//        }
//        ByteBuf resq = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.writeAndFlush(resq);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}