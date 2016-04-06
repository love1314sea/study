package netty.demo1;

/**
 * Created by wushang on 16/2/17.
 */
import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;
import scala.util.control.Exception;


/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
        System.out.println("read begin---");
        ByteBuf in = (ByteBuf)msg;
        while(in.isReadable()) {
            System.out.print((char)in.readByte());
            System.out.flush();
        }
        ctx.write(msg);
        ctx.flush();
        System.out.println("read end" + "---");
//        ((ByteBuf) msg).release(); // (3)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}