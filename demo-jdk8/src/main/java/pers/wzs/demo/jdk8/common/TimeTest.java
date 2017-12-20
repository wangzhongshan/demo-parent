package pers.wzs.demo.jdk8.common;

import java.time.Duration;

/**
 * Created by wangzhongshan on 2017/11/23.
 */
public class TimeTest {
    public static void main(String[] args) {
        Duration duration = Duration.ofSeconds(1002223);
        System.out.println(duration.toHours() + ":" + duration.toMinutes());
        System.out.println(duration.toString());
    }
}
