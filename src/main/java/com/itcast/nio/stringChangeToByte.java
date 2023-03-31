package com.itcast.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.itcast.nio.Util.ByteBufferUtil.debugAll;

/**
 * 字符串转化成byteBuffer的三种方式
 */
public class stringChangeToByte {
    public static void main(String[] args) {
        //第一种方式
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.put("hello".getBytes());
        debugAll(byteBuffer);
        //第二种方式,转换成功就切换成读模式，position在索引0的位置
        ByteBuffer byteBuffer1 = StandardCharsets.UTF_8.encode("hello");
        debugAll(byteBuffer1);
        //第三种方式,转换成功就切换成读模式，position在索引0的位置
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("hello".getBytes());
        debugAll(byteBuffer2);
    }
}
