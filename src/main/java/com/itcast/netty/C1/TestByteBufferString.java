package com.itcast.netty.C1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.itcast.netty.utils.ByteBufferUtil.debugAll;

/**
 * ByteBuffer和字符串相互转化
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        //1.字符串转为ByteBuffer
        ByteBuffer buffer1 = ByteBuffer.allocate(16);
        buffer1.put("hello".getBytes());
        debugAll(buffer1);

        //2.charset
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer2);

        //3.wrap
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buffer3);

        //4.转为字符串
        String s = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(s);

        //5.转字符串
        buffer1.flip();
        String s1 = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println(s1);

    }
}
