package netty.使用protobuf.client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import netty.使用protobuf.StudentOuterClass;

/**
 * Created by wushang on 16/4/7.
 */
public class ChatRoomClientHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client channelRead---");
        StudentOuterClass.Student student = (StudentOuterClass.Student)msg;
        System.out.println("name=" + student.getName());
        System.out.println("age=" + student.getAge());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
