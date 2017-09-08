package pers.wzs.demo.jdk8.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by wangzhongshan on 2017/9/8.
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println(path.getNameCount());
        System.out.println(path);

    }
}
