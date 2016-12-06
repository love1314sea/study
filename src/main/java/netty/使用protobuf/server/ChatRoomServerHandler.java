package netty.使用protobuf.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import netty.使用protobuf.StudentOuterClass;

/**
 * Created by wushang on 16/4/7.
 */
public class ChatRoomServerHandler extends ChannelHandlerAdapter {

    //这个要定义成静态的,所有的客户端 只对一个服务端
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.writeAndFlush("[server] - " + incoming.remoteAddress() + "加入\n");
        }
        channels.add(incoming);
        incoming.writeAndFlush("[server] - " + "你加入了聊天室\n");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();


        for (Channel channel : channels) {
            if(channel != incoming) {
                channel.writeAndFlush("[server] - " + incoming.remoteAddress() + "离开\n");
            }
        }

        channels.remove(incoming);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " online");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " offline");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead---");
        Channel channel = ctx.channel();
        StudentOuterClass.Student student = (StudentOuterClass.Student)msg;
        System.out.println("name=" + student.getName());
        System.out.println("age=" + student.getAge());

        StudentOuterClass.Student student2 = StudentOuterClass.Student.newBuilder().setAge(44).setName("li").build();
        channel.writeAndFlush(student2);
        System.out.println("server channelRead over---");
    }
}
