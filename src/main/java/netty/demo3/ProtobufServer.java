//package netty.demo3;
//
///**
// * Created by wushang on 16/2/17.
// */
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.DelimiterBasedFrameDecoder;
//import io.netty.handler.codec.protobuf.ProtobufEncoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
//import netty.demo2.TimeServerHandler;
//
//import java.net.InetAddress;
//
///**
// * Discards any incoming data.
// */
//public class ProtobufServer {
//
//    private int port;
////    private final static String DELIMITER = System.getProperty("line.separator");
//    private final static String DELIMITER = "$_";
//    private final static ByteBuf DELIMITER_BUF;
//
//    static {
//        DELIMITER_BUF = Unpooled.buffer(DELIMITER.getBytes().length);
//        DELIMITER_BUF.writeBytes(DELIMITER.getBytes());
//    }
//
//    public ProtobufServer(int port) {
//        this.port = port;
//    }
//
//    public void run() throws Exception {
//        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap b = new ServerBootstrap(); // (2)
//            b.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class) // (3)
//                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
//                        @Override
//                        public void initChannel(SocketChannel ch) throws Exception {
////                             ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
////                            ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
////                            ch.pipeline().addLast(new ProtobufEncoder());
//                            System.out.println(ch.remoteAddress().getAddress().getHostAddress());
////                            System.out.println("address=" + address.);
//                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(10240, DELIMITER_BUF));
//                            ch.pipeline().addLast(new ProtobufServerHandler());
//
//                        }
//                    })
//                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
//
//            // Bind and start to accept incoming connections.
//            ChannelFuture f = b.bind(port).sync(); // (7)
//
//            // Wait until the server socket is closed.
//            // In this example, this does not happen, but you can do that to gracefully
//            // shut down your server.
//            f.channel().closeFuture().sync();
//        } finally {
//            workerGroup.shutdownGracefully();
//            bossGroup.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        int port;
//        if (args.length > 0) {
//            port = Integer.parseInt(args[0]);
//        } else {
//            port = 8080;
//        }
//        new ProtobufServer(port).run();
//
//    }
//}