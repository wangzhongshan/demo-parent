package pers.wzs.demo.jdk8.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhongshan on 2017/3/28.
 */
public class MapDemo {
    public static void main(String[] args) {
        merge();
        getOrDefault();
    }

    private static void getOrDefault() {
        Map<String, Integer> map = new HashMap<>();
        Integer value = 3;
        String key = "aaa";
//        System.out.println(map.containsKey(key) ? map.get(key) : value);
        System.out.println(map.getOrDefault(key, value));

    }

    public static void merge() {
        Map<String, Integer> map = new HashMap<>();
        String key = "aaa";
        map.put(key, 3);
        map.merge(key, 1, (a, b) -> a + b);
        System.out.println(map.get(key));
    }
}
