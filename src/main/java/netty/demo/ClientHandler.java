package netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.util.Date;

/**
 * Created by wushang on 16/4/14.
 */

public class ClientHandler extends ChannelHandlerAdapter {

    //    private final ByteBuf firstMessage;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("client active");
//        URI uri = new URI("http://localhost:8080/getRedirectHost");
//        URI uri = new URI("http://192.168.1.129:9999/");
//        while (true) {
            URI uri = new URI("/");
            String msg = "hello girl";
            StringBuilder buf = new StringBuilder(msg + ":" + ctx.channel().localAddress());
//        for(int i=0; i<10000; ++i) {
//            buf.append(msg);
//        }
//        FullHttpMessage request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
            FullHttpMessage request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
                    uri.toASCIIString());
            System.out.println(new Date() + ": clinet" + ctx.channel().localAddress());

//        request.headers().set(HttpHeaderNames.HOST, "localhost");
            request.headers().set(HttpHeaderNames.HOST, "192.168.1.129");
            request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            request.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.toString(request.content().readableBytes()));
            ctx.writeAndFlush(request);
//            Thread.sleep(10000);
//        }
//        System.out.println(new Date() + ": over----");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;
//            System.out.println("CONTENT_TYPE:" + response.headers().get(HttpHeaderNames.CONTENT_TYPE));
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
//            System.out.println("content :"  + buf.toString(io.netty.util.CharsetUtil.UTF_8));
            buf.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

