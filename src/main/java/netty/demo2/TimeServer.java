//package netty.demo2;
//
///**
// * Created by wushang on 16/2/17.
// */
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.DelimiterBasedFrameDecoder;
//import io.netty.handler.codec.http.HttpRequestDecoder;
//import io.netty.handler.codec.http.HttpResponseEncoder;
//import io.netty.handler.codec.string.StringDecoder;
//
///**
// * Discards any incoming data.
// */
//public class TimeServer {
//
//    private int port;
//    private final static String DELIMITER = System.getProperty("line.separator");
//    private final static ByteBuf DELIMITER_BUF;
//
//    static {
//        DELIMITER_BUF = Unpooled.buffer(DELIMITER.getBytes().length);
//        DELIMITER_BUF.writeBytes(DELIMITER.getBytes());
//    }
//
//    public TimeServer(int port) {
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
////                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, DELIMITER_BUF));
////                            ch.pipeline().addLast(new StringDecoder());
////                            ch.pipeline().addLast(new TimeServerHandler());
//
//                            ChannelPipeline p = ch.pipeline();
//                            p.addLast(new HttpRequestDecoder());
//                            p.addLast(new HttpResponseEncoder());
//                            p.addLast(new ServerHandler());
//
//                            p.addLast(new DelimiterBasedFrameDecoder(1024, DELIMITER_BUF));
//                            p.addLast(new StringDecoder());
//                            p.addLast(new TimeServerHandler());
//
//
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
//        new TimeServer(port).run();
//
//    }
//}