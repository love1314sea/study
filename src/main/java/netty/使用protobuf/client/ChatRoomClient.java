//package netty.使用protobuf.client;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.DelimiterBasedFrameDecoder;
//import io.netty.handler.codec.protobuf.ProtobufDecoder;
//import io.netty.handler.codec.protobuf.ProtobufEncoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
//import netty.使用protobuf.StudentOuterClass;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///**
// * Created by wushang on 16/4/7.
// */
//public class ChatRoomClient {
//	private final static String DELIMITER = System.getProperty("line.separator");
//	private final static ByteBuf DELIMITER_BUF;
//
//	static {
////		DELIMITER_BUF = Unpooled.buffer(DELIMITER.getBytes().length);
////		DELIMITER_BUF.writeBytes(DELIMITER.getBytes());
//
//		DELIMITER_BUF = Unpooled.buffer(2);
//		DELIMITER_BUF.writeInt(0xFF00);
//	}
//
//	public void connect(String host, int port) throws Exception {
//		EventLoopGroup group = new NioEventLoopGroup();
//		Bootstrap bootstrap = new Bootstrap();
//		try {
////			bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
////					.handler(new ChannelInitializer<SocketChannel>() {
////						@Override
////						protected void initChannel(SocketChannel ch) throws Exception {
////							ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
////							ch.pipeline().addLast(new ProtobufDecoder(StudentOuterClass.Student.getDefaultInstance()));
////							ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
////							ch.pipeline().addLast(new ProtobufEncoder());
////							ch.pipeline().addLast(new ChatRoomClientHandler());
////						}
////					});
//
//			bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
//					.handler(new ChannelInitializer<SocketChannel>() {
//						@Override
//						protected void initChannel(SocketChannel ch) throws Exception {
//							ch.pipeline().addLast(new DelimiterBasedFrameDecoder(8042, DELIMITER_BUF));
//							ch.pipeline().addLast(new ProtobufDecoder(StudentOuterClass.Student.getDefaultInstance()));
//							ch.pipeline().addLast(new ProtobufEncoder());
//							ch.pipeline().addLast(new ChatRoomClientHandler());
//						}
//					});
//
//
//			ChannelFuture future = bootstrap.connect(host, port).sync();
//			Channel channel = future.channel();
//
////			StudentOuterClass.Student student = StudentOuterClass.Student.newBuilder().setAge(14).setName("zhang").build();
////			channel.writeAndFlush(student);
//
//			StudentOuterClass.Student student = StudentOuterClass.Student.newBuilder().setAge(14).setName("zhang").build();
//			byte[] bytes = student.toByteArray();
//
//			byte[] msg = new byte[bytes.length + 2];
//			System.arraycopy(bytes, 0, msg, 0, bytes.length);
//			byte[] intbytes = new byte[]
//			System.arraycopy(bytes, bytes.length, msg, 0, bytes.length);
//			channel.writeAndFlush(student);
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			while (true) {
//				String line = reader.readLine();
//				if ("quit".equals(line)) {
//					break;
//				}
//				channel.writeAndFlush(line + "\n");
//			}
//			channel.closeFuture().sync();
//
//		} finally {
//			group.shutdownGracefully();
//		}
//	}
//
//
//	public static void main(String[] args) throws Exception {
//		int port = 8080;
//		if (args != null && args.length > 0) {
//			port = Integer.parseInt(args[0]);
//		}
//		new ChatRoomClient().connect("localhost", port);
//	}
//}
