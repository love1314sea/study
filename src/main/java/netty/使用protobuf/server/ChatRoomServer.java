package netty.使用protobuf.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import netty.使用protobuf.StudentOuterClass;

/**
 * Created by wushang on 16/4/7.
 */
public class ChatRoomServer {
    private int port;
    private final static String DELIMITER = System.getProperty("line.separator");
    private final static ByteBuf DELIMITER_BUF;

    static {
//        DELIMITER_BUF = Unpooled.buffer(DELIMITER.getBytes().length);
//        DELIMITER_BUF.writeBytes(DELIMITER.getBytes());

        DELIMITER_BUF = Unpooled.buffer(2);
        DELIMITER_BUF.writeInt(0xFF00);
    }
    public ChatRoomServer(int port) {
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        ServerBootstrap b = new ServerBootstrap();
//        b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
//                    @Override
//                    public void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//                        ch.pipeline().addLast(new ProtobufDecoder(StudentOuterClass.Student.getDefaultInstance()));
//                        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
//                        ch.pipeline().addLast(new ProtobufEncoder());
//                        ch.pipeline().addLast(new ChatRoomServerHandler());
//
//                    }
//                }).option(ChannelOption.SO_BACKLOG, 128)          // (5)
//                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)


        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(8042, DELIMITER_BUF));
                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                        ch.pipeline().addLast(new ProtobufDecoder(StudentOuterClass.Student.getDefaultInstance()));
                        ch.pipeline().addLast(new ProtobufEncoder());
                        ch.pipeline().addLast(new ChatRoomServerHandler());

                    }
                }).option(ChannelOption.SO_BACKLOG, 128)          // (5)
                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)


        ChannelFuture f = b.bind(port).sync(); // (7)
        f.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws Exception{
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new ChatRoomServer(port).run();
    }
}
