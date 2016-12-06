package netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by wushang on 16/4/13.
 */
public class OpenRestyClient {
    private int connectNum = 3;
    private ConcurrentLinkedQueue<Channel> list = null;
    private int cycle;

    public OpenRestyClient(int connectNum, int cycle) {
        this.connectNum = connectNum;
        this.cycle = cycle;
        cycleConnect();
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
                            pipeline.addLast("handler", new ClientHandler());

                        }
                    });

            list = new ConcurrentLinkedQueue<>();
            for (int i = 0; i < connectNum; ++i) {
                ChannelFuture future = bootstrap.connect(host, port).sync();
                list.add(future.channel());
                Thread.sleep(1);
                if (i % 1000 == 0) {
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
        int cycle = 3;
        if (args != null && args.length > 0) {
            connectNum = Integer.parseInt(args[1]);
            cycle = Integer.parseInt(args[2]);
        }
//        System.out.println("server=" + args[0] + " connectNum=" + connectNum);
        System.out.println("server=" + ip + " connectNum=" + connectNum);

//        new NettyClient(connectNum).connect(args[0], port);
        OpenRestyClient client = new OpenRestyClient(connectNum, cycle);
        client.connect(ip, port);
    }

    private void cycleConnect() {
        Timer timer = new Timer();
        long intevalPeriod = 1 * 1000 * 60 * cycle;
        timer.scheduleAtFixedRate(task, intevalPeriod, intevalPeriod);
    }

    public TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("timer task----");
            int i = 0;
            try {
                for (Channel channel : list) {
                    Thread.sleep(1);
                    i++;
                    URI uri = new URI("/");
                    FullHttpMessage request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
                            uri.toASCIIString());
                    System.out.println(new Date() + ": clinet in task :" + i + ":" + channel.localAddress());
                    request.headers().set(HttpHeaderNames.HOST, "192.168.1.129");
                    request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                    request.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.toString(request.content().readableBytes()));
                    channel.writeAndFlush(request);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}


