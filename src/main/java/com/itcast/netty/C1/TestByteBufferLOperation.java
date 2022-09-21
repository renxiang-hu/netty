package com.itcast.netty.C1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.itcast.netty.utils.ByteBufferUtil.debugAll;

public class TestByteBufferLOperation {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

        //从头开始读
        buffer.get(new byte[4]);
        debugAll(buffer);
    }
}
