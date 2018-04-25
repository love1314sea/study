package netty.demo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wushang on 16/4/13.
 */
//问题：
public class ServerHandler extends ChannelHandlerAdapter {
    private static AtomicLong count = new AtomicLong(0);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NO." + count.incrementAndGet() + " 连接");
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

//        System.out.println("连接关闭");
    }

}
