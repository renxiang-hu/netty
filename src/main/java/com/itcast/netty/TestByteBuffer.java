package com.itcast.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) throws Exception {
        //输入流
        try (FileInputStream fis = new FileInputStream("data.txt")){
            //获取通道
            FileChannel fisChannel = fis.getChannel();
            //分配缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            while (true) {
                //将channel中的数据读到byteBuffer中
                int read = fisChannel.read(byteBuffer);
                log.info("读取到的字节数量{}",read);
                if (read == -1){
                    break;
                }
                //切换至读模式
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    log.info("读取到的字节{}",(char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
