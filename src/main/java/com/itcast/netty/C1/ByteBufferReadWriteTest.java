package com.itcast.netty.C1;

import java.nio.ByteBuffer;

import static com.itcast.netty.utils.ByteBufferUtil.debugAll;

public class ByteBufferReadWriteTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61);
        debugAll(buffer);
        buffer.put(new byte[]{0x62,0x63,0x64});
        debugAll(buffer);
        System.out.println(buffer.get());
        buffer.flip();
        System.out.println(buffer.get());
        debugAll(buffer);
    }
}
