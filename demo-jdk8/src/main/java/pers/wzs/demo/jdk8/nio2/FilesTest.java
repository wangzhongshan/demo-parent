package pers.wzs.demo.jdk8.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by wangzhongshan on 2017/9/8.
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/Mtime/Downloads/SenseME.lic");
        Path pathDir = Paths.get("/Users/Mtime/Downloads/");
        // Path path1 = Paths.get("/Users/Mtime/Downloads/SenseME.lic1");
        //复制文件
        // Files.copy(path, Files.newOutputStream(Paths.get("/Users/Mtime/Downloads/SenseME.lic1")));
        // System.out.println(Files.isHidden(path));
        // for (String s : Files.readAllLines(path)) {
        //     System.out.println("读取一行：" + s);
        // }
        // byte[] bytes = Files.readAllBytes(path);
        // Files.write(path1, bytes);
        // Files.lines(path).forEach(System.out::println);
        // Files.list(pathDir).forEach(System.out::println);
        Files.walk(pathDir).forEach(System.out::println);
    }
}
