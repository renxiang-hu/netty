package com.itcast.nio.C1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

@Slf4j
public class Server {
    public static void main(String[] args) throws IOException {
        //创建selector，管理多个channel
        Selector selector = Selector.open();

        //创建服务器  监听客户端连接请求并创建对应的 SocketChannel 实例来处理连接请求。
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //非阻塞模式
        ssc.configureBlocking(false);
        //绑定监听接口 表示服务器将在本地监听 8080 端口，等待客户端连接请求的到来。
        ssc.bind(new InetSocketAddress(8090));
        //建立selector和channel的联系
        //Selectionkey就是将来事件发生后，通过他可以知道事件和哪个channel的事件
        SelectionKey selectionKey = ssc.register(selector, 0, null);
        //key只关注accept事件
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);
        log.debug("register key:{}",selectionKey);

        while (true) {
            //select 方法，没有事件发生，线程阻塞，有事件，线程恢复正常
            selector.select();
            //处理事件，selectedKeys 内部包含了所有发生事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                log.debug("key:{}",next);
                ServerSocketChannel channel = (ServerSocketChannel)next.channel();
                SocketChannel accept = channel.accept();
                log.debug("{}",accept);
            }
        }
    }
}
