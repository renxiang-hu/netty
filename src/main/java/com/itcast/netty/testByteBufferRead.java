package com.itcast.netty;

import java.nio.ByteBuffer;

import static com.itcast.netty.Util.ByteBufferUtil.debugAll;

public class testByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put(new byte[]{'a','b','c','d','e'});
        byteBuffer.flip();

        //rewind 从头开始读
        byteBuffer.get(new byte[1]);
        debugAll(byteBuffer);
        //position到了0位置
        byteBuffer.rewind();
        //获取第0个位置的字符
        System.out.println((char) byteBuffer.get());

        //ramark && reset
        //remark做一个标记，记录position的位置
        //reset是将position重置到mark的位置
        System.out.println((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());
        //加标记，记录索引为2的位置
        byteBuffer.mark();
        System.out.println((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());
        //将position重置到索引2
        byteBuffer.reset();
        System.out.println((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());
    }
}
