//package netty.demo4;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpRequestDecoder;
//import io.netty.handler.codec.http.HttpResponseEncoder;
//import io.netty.handler.ssl.SslContext;
//import io.netty.handler.ssl.util.SelfSignedCertificate;
//
//import javax.net.ssl.SSLException;
//import java.security.cert.CertificateException;
//
//
///**
// * Created by wushang on 16/4/13.
// */
//public class HttpServer {
//    private int port = 80;
//
//    public HttpServer() {
//
//    }
//
//    public HttpServer(int port) {
//        this.port = port;
//    }
//
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//
//    private void run() throws Exception{
//
//        final SslContext sslCtx;
//
//
//
//        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
//        NioEventLoopGroup workGroup = new NioEventLoopGroup();
//        try {
////            SelfSignedCertificate ssc = new SelfSignedCertificate();
////            具体场景要通过文件
////            sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
//
//            ServerBootstrap bootstrap = new ServerBootstrap();
//            bootstrap.group(bossGroup, workGroup);
//            bootstrap.channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
//                @Override
//                protected void initChannel(SocketChannel ch) throws Exception {
//                    ChannelPipeline pipeline = ch.pipeline();
////                    pipeline.addLast(sslCtx.newHandler(ch.alloc()));
//                    pipeline.addLast("decoder", new HttpRequestDecoder());
//                    pipeline.addLast("encoder", new HttpResponseEncoder());
////                    pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
////                    pipeline.addLast("deflater", new HttpContentCompressor());
//                    pipeline.addLast("handler", new HttpServerHandler());
//                }
//            }).option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            Channel channel = bootstrap.bind(port).sync().channel();
//            channel.closeFuture().sync();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
////        } catch (CertificateException e) {
////            e.printStackTrace();
////        } catch (SSLException e) {
////            e.printStackTrace();
//        } finally {
//            workGroup.shutdownGracefully();
//            workGroup.shutdownGracefully();
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        int port = 9999;
//        new HttpServer(port).run();
//    }
//
//}
