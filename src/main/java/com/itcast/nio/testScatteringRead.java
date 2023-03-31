package com.itcast.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.itcast.nio.Util.ByteBufferUtil.debugAll;

/**
 * 分散读，比如"onetwothree",分别读取one，two，three
 */
public class testScatteringRead {
    public static void main(String[] args) {
        try (FileChannel fileChannel = new FileInputStream("data.txt").getChannel()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(3);
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(3);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(5);
            fileChannel.read(new ByteBuffer[]{byteBuffer,byteBuffer1,byteBuffer2});
            byteBuffer.flip();
            byteBuffer1.flip();
            byteBuffer2.flip();
            debugAll(byteBuffer);
            debugAll(byteBuffer1);
            debugAll(byteBuffer2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
