package pers.wzs.demo.jdk8.common;

import java.io.File;

/**
 * Created by wangzhongshan on 2017/9/8.
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("/Users/Mtime/Downloads/SenseME.lic");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.getPath());
        System.out.println(file.list());
        System.out.println(file.getParent());
        File dir = new File(file.getParent());
        for (String s : dir.list()) {
            System.out.println(s);
        }
    }
}
