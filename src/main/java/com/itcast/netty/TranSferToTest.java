package com.itcast.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * transferTo : 将一个channel中的数据传到另一个channel中
 */
public class TranSferToTest {
    public static void main(String[] args) {
        try(FileChannel fileChannel = new FileInputStream("data.txt").getChannel();
            FileChannel fileChannel1 = new FileOutputStream("data01.txt").getChannel()) {
            fileChannel.transferTo(0,fileChannel.size(),fileChannel1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
