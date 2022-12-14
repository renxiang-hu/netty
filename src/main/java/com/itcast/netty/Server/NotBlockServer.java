package com.itcast.netty.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.itcast.netty.utils.ByteBufferUtil.debugRead;

/**
 * 通过nio理解阻塞模式
 */
public class NotBlockServer {
    public static void main(String[] args) throws IOException {
        //0.ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        //1.创建了服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        //2.绑定监听端口
        ssc.bind(new InetSocketAddress(8080));
        //3.连续集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true){
            SocketChannel sc = ssc.accept();  //非阻塞方法，线程继续执行，如果没有建立连接，sc返回null
            if (sc != null){
                System.out.println("connected : " + sc);
                channels.add(sc);
            }
            for (SocketChannel channel : channels){
                System.out.println("before read :"+ channel);
                //5.接收客户发送的信息
                int read = channel.read(buffer);//非阻塞方法，线程仍然继续执行，如果没有读到数据，read返回0
                if (read > 0){
                    buffer.flip();
                    debugRead(buffer);
                    buffer.clear();
                    System.out.println("after read : " + channel);
                }
            }
        }
    }
}
