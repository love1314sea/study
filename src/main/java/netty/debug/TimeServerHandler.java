package netty.debug;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * Created by wushang on 16/2/17.
 */
public class TimeServerHandler extends SimpleChannelInboundHandler<String> {

    //     the channelActive() method will be invoked when a connection is established and ready to generate traffic
    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        System.out.println("TimeServerHandler channelActive1---");
        System.out.println("TimeServerHandler channelActive2---");
    }


    @Override
    public void channelRead0(ChannelHandlerContext ctx, String body) throws Exception {

        System.out.println("The time server receive body:" + body);
        Thread.sleep(100000);
        String currentTime = "BAD ORDER";
        if ("QUERY TIME ORDER".equals(body)) {
            currentTime = new Date(System.currentTimeMillis()).toString();
        }

//        ctx.pipeline().writeAndFlush(currentTime + System.getProperty("line.separator"));
        /*
        //1 Outbound异常并不会被捕获
        //2 调用ctx.writeAndFlush，ctx是开始，有截断，注意这块
        ChannelFuture future = ctx.writeAndFlush(currentTime + System.getProperty("line.separator"));
        if(!future.sync().isSuccess()) {
            System.out.println(future.get());
        }
        */
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