package pers.wzs.demo.jdk8.common;

import java.lang.management.ManagementFactory;

/**
 * Created by wangzhongshan on 2017/10/24.
 */
public class CommonTest {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
    }
}
