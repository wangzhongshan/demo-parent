package pers.wzs.demo.jdk8.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by wangzhongshan on 2017/7/4.
 */
public class PathsAndFilesDemo {
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("demo-jdk8/src/main/java/pers/wzs/demo/jdk8/nio2","PathsAndFilesDemo.java");
//        System.out.println(path);
//        List<String> allLines = Files.readAllLines(path, Charset.defaultCharset());
//        System.out.println(allLines);
//        Files.list(path).forEach(System.out::println);
//        Files.lines(path).forEach(System.out::println);
        Path path1 = Paths.get(".");
        System.out.println(path1);
        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("文件：" + file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("目录：" + dir + "结束");
                return super.postVisitDirectory(dir, exc);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("目录：" + dir + "开始");
                return super.preVisitDirectory(dir, attrs);
            }
        });
    }
}
