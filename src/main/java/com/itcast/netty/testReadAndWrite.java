package com.itcast.netty;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

import static com.itcast.netty.Util.ByteBufferUtil.debugAll;

@Slf4j
public class testReadAndWrite {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 0x61);
        debugAll(byteBuffer);
        byteBuffer.put(new byte[]{0x62,0x63});
        debugAll(byteBuffer);
        //如果不用byteBuffer，get的是第四个字符，就是0
        System.out.println(byteBuffer.get());
        byteBuffer.flip();
        //byteBuffer的flip执行后，会从第一个字符开始，就是a
        System.out.println((char) byteBuffer.get());
    }
}
