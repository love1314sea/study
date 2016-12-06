package netty.demo4;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_0;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static io.netty.handler.codec.rtsp.RtspHeaderNames.CONTENT_LENGTH;

/**
 * Created by wushang on 16/4/14.
 */
@ChannelHandler.Sharable
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        String result;
        System.out.println("TEST:" + "messageReceived---");
        long startTime = System.currentTimeMillis();
        if (httpObject instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) httpObject;
            HttpMethod method = request.method();
            if (!(method.equals(HttpMethod.GET) || method.equals(HttpMethod.POST))) {
                System.out.println("yes get");
                result = "{\"status\":\"error\",\"result\":{\"errorCode\":-1,\"errorMessage\":\"Request method '" + method + "' not supported\"}}";
                FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, METHOD_NOT_ALLOWED, Unpooled.wrappedBuffer(result.getBytes("UTF-8")));
                ctx.write(response);
                return;
            }
            String requestURI = request.uri();
            System.out.println("version=" + request.protocolVersion());
            System.out.println("uri=" + requestURI);
            HttpHeaders headers = request.headers();

            String key = null;
            result = "good";
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(result.getBytes("UTF-8")));
            response.headers().set(CONTENT_TYPE, "text/plain");
//            response.headers().set(CONTENT_LENGTH, String.valueOf(response.content().readableBytes()));
//            response.headers().set(CONNECTION, Values.KEEP_ALIVE);
            ctx.writeAndFlush(response);
            ctx.close();
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NO." + " 连接");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        System.out.println("连接关闭");
    }


}
