package com.itcast.netty.C1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 文件拷贝
 */
public class TestFilesCopy {
    public static void main(String[] args) throws IOException {
        String source = "/Users/hurenxiang/Desktop/思维导图";
        String target = "/Users/hurenxiang/Desktop/思维导图aaa";
        Files.walk(Paths.get(source)).forEach(path -> {
            try {
                String replace = path.toString().replace(source, target);
                //是目录
                if (Files.isDirectory(path)){
                    Files.createDirectories(Paths.get(target));
                }
                // 普通文件
                else if (Files.isRegularFile(path)){
                    Files.copy(path,Paths.get(replace));
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
