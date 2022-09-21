package com.itcast.netty.C1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class testByteBuffer {

    public static void main(String[] args) {
        //FileChannel
        //1.输入输出流  2.RandomAccessFile
        try(FileChannel channel = new FileInputStream("data.txt").getChannel()){
            //准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true){
                //从channel读取数据，向buffer写入
                int len = channel.read(buffer);
                if (len == -1){
                    break;
                }
                //打印buffer内容
                buffer.flip();  //切换至读模式
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                }
                buffer.clear(); //切换至写模式
            }
        } catch (IOException e){

        }
    }
}
