package pers.wzs.demo.jdk8.common;

import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.net.URLEncoder;

/**
 * Created by wangzhongshan on 2017/10/24.
 */
public class CommonTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // String name = ManagementFactory.getRuntimeMXBean().getName();
        // System.out.println(name);
        String encode = URLEncoder.encode("北京", "utf-8");
        System.out.println(encode);
    }
}
