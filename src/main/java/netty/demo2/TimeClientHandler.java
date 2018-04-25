//package netty.demo2;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelHandlerAdapter;
//import io.netty.channel.ChannelHandlerContext;
//
///**
// * Created by wushang on 16/3/31.
// */
//public class TimeClientHandler extends ChannelHandlerAdapter {
//    private final static String DELIMITER = System.getProperty("line.separator");
//    //    private final ByteBuf firstMessage;
////
////    public TimeClientHandler() {
////        byte[] req = "QUERY TIME ORDER".getBytes();
////        firstMessage = Unpooled.buffer(req.length);//生成ByteBuf对象
////        firstMessage.writeBytes(req);
////    }
//    @Override
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
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        System.out.println("Now is :" + body);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}
