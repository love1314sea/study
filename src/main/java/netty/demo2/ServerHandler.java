package netty.demo2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

import java.net.InetSocketAddress;

/**
 * Created by wushang on 16/4/5.
 */
public class ServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("re2----");
        if (msg instanceof HttpRequest) {
            HttpRequest mReq = (HttpRequest) msg;
            System.out.println("yes2---");
            System.out.println("size=" + mReq.headers().size());
            HttpHeaders headers = mReq.headers();
            String clientIp = "";
            if(headers.contains("X-Forwarded-For")) {
                clientIp = headers.get("X-Forwarded-For").toString();
            }
            System.out.println("ip 2--" + clientIp);
            if (clientIp == "") {
                InetSocketAddress insocket = (InetSocketAddress) ctx.channel()
                        .remoteAddress();
                clientIp = insocket.getAddress().getHostAddress();
            }
        }
    }
}