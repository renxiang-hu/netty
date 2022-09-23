package com.itcast.netty.C1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 复制一个文件中的内容到另一个文件
 */
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try(FileChannel from  =  new FileInputStream("data.txt").getChannel();
            FileChannel to = new FileOutputStream("to.txt").getChannel();){
            //效率高，底层会利用操作系统的零拷贝进行优化
            from.transferTo(0,from.size(),to);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
