package com.itcast.netty.C1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class HelloServer {
    public static void main(String[] args) {
        //1.启动器，负责组装netty组件，启动服务器
        new ServerBootstrap()
                //2. group组
                .group(new NioEventLoopGroup())
                //3.选择服务器的serverSocketChannel实现
                .channel(NioServerSocketChannel.class)
                //4.boss 负责处理连接worker，负责处理读写，决定了worker能执行哪些操作handler
                .childHandler(
                        //5.channel代表和客户端进行数据读写的通道  Initializer初始化，负责添加别的handler
                        new ChannelInitializer<NioSocketChannel>() {
                            @Override
                            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                                //6.添加具体handler  将ByteBuff转换成字符串
                                nioSocketChannel.pipeline().addLast(new StringDecoder());
                                //自定义handler
                                nioSocketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
                                        //打印上一步转换好的字符串
                                        System.out.println(msg);
                                    }
                                });
                            }
                        }
                //绑定监听端口
                ).bind(8040);
    }
}
