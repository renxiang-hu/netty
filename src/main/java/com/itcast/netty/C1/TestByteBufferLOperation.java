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
        buffer.rewind();
        debugAll(buffer);

        //mark & reset
        //mark做一个标记，记录position的位置，reset是将position重置到mark位置
        System.out.println((char) buffer.get());  // a
        System.out.println((char) buffer.get());  // b
        buffer.mark();  //加标记，索引2的位置        // 这是把mark标记到索引为2的位置
        System.out.println((char) buffer.get());  // c
        System.out.println((char) buffer.get());  // d
        buffer.reset();  //重新回到索引为2的位置     // 这是重新指向索引为2的位置
        System.out.println((char) buffer.get());  // c

        //get(i)
        System.out.println((char) buffer.get(3));
    }
}
