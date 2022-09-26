package com.itcast.netty.C1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 删除目录(目录下会包含很多子目录)
 */
public class DeleteFileTree {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("/Users/hurenxiang/Desktop/javaTest/springcloud的副本"),new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });
    }
}
