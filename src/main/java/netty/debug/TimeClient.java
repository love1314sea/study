//package netty.debug;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.DelimiterBasedFrameDecoder;
//import io.netty.handler.codec.string.StringDecoder;
//import io.netty.handler.codec.string.StringEncoder;
//
///**
// * Created by wushang on 16/3/30.
// */
//public class TimeClient {
//    private final static String DELIMITER = System.getProperty("line.separator");
//    private final static ByteBuf DELIMITER_BUF;
//
//    static {
//        DELIMITER_BUF = Unpooled.buffer(DELIMITER.getBytes().length);
//        DELIMITER_BUF.writeBytes(DELIMITER.getBytes());
//    }
//    public void connect(String host, int port) throws Exception {
//        EventLoopGroup group = new NioEventLoopGroup();
//        Bootstrap bootstrap = new Bootstrap();
//        try {
//            bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new StringEncoder());//out
//
//                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, DELIMITER_BUF));
//                            ch.pipeline().addLast(new StringDecoder());
//                            ch.pipeline().addLast(new TimeClientHandler());
//
//                        }
//                    });
//
//            ChannelFuture future = bootstrap.connect(host, port).sync();
//            Channel channel = future.channel();
//            channel.writeAndFlush("zhangsan");
//            channel.writeAndFlush(System.getProperty("line.separator"));
//            channel.closeFuture().sync();
//        } finally {
//            group.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        int port = 8080;
//        if (args != null && args.length > 0) {
//            port = Integer.parseInt(args[0]);
//        }
//        new TimeClient().connect("localhost", port);
//    }
//}
