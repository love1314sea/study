package netty.聊天室.client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by wushang on 16/4/7.
 */
public class ChatRoomClientHandler extends ChannelHandlerAdapter {
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println((String)msg);
    }
}
