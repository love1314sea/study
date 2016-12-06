package netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

/**
 * Created by wushang on 16/4/13.
 */
public class NettyClient {
    private int connectNum = 3;

    public NettyClient(int connectNum) {
        this.connectNum = connectNum;
    }

    public void connect(String host, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new HttpResponseDecoder());
                            pipeline.addLast("encoder", new HttpRequestEncoder());
                            // pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
                            pipeline.addLast("handler", new NettyClientHandler());
                        }
                    });


            for (int i = 0; i < connectNum; ++i) {
                bootstrap.connect(host, port).sync();
                Thread.sleep(1);
                if(i%1000 == 0) {
                    System.out.println("connection:" + i);
                }
            }
            Thread.sleep(10000000);

        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
//        String ip = "192.168.2.132";
        String ip = args[0];

        final int port = 9999;
        int connectNum = 10;
        if (args != null && args.length > 0) {
            connectNum = Integer.parseInt(args[1]);
        }
//        System.out.println("server=" + args[0] + " connectNum=" + connectNum);
        System.out.println("server=" + ip + " connectNum=" + connectNum);

//        new NettyClient(connectNum).connect(args[0], port);
        new NettyClient(connectNum).connect(ip, port);

    }
}
