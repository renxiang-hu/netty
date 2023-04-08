package com.itcast.netty;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestEventLoop {
    public static void main(String[] args) {
        //1.创建事件循环组
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2); //io事件，普通任务，定时任务
//        EventLoopGroup eventLoopGroup1 = new DefaultEventLoopGroup(); //普通任务、定时任务
        System.out.println(NettyRuntime.availableProcessors());
        //获取下一个事件循环对象
        System.out.println(eventLoopGroup.next());
        System.out.println(eventLoopGroup.next());
        System.out.println(eventLoopGroup.next());
        //执行定时任务
        eventLoopGroup.next().scheduleAtFixedRate(()->{
            log.debug("ok");
        },0,1, TimeUnit.SECONDS);
    }
}
