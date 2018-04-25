//package netty.debug;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelOutboundHandler;
//import io.netty.channel.SimpleChannelInboundHandler;
//
///**
// * Created by wushang on 16/3/31.
// */
//public class TimeClientOutHandler extends ChannelOutboundHandler {
//    private final static String DELIMITER = System.getProperty("line.separator");
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) {
//
//    }
//
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) {
//
//    }
//
//
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//
//        for (int i = 0; i < 5; ++i) {
//            byte[] req = ("QUERY TIME ORDER" + DELIMITER).getBytes();
//            ByteBuf firstMessage = Unpooled.buffer(req.length);
//            firstMessage.writeBytes(req);
//
//            ctx.writeAndFlush(firstMessage);
//            System.out.println(firstMessage.readableBytes());
//        }
//    }
//
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}
