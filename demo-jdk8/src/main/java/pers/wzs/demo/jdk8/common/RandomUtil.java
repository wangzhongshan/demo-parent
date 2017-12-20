package pers.wzs.demo.jdk8.common;

import java.util.*;

/**
 * Created by wangzhongshan on 2017/12/20.
 */
public class RandomUtil {

    public static List<Integer> getUniqueRandoms(int size, int end) {
        if (size < 1) {
            throw new RuntimeException("size must > 0");
        }
        if (end < size) {
            throw new RuntimeException("end must > size");
        }
        List<Integer> list = new ArrayList<>(size);
        Set<Integer> set = new HashSet<>(size);
        Random random = new Random();
        while (set.size() < size) {
            int newRand = random.nextInt(end);
            if (set.contains(newRand)) {
                continue;
            } else {
                list.add(newRand);
                set.add(newRand);
            }
        }
        return list;
    }

    public static void main(String[] args){
        List<Integer> uniqueRandomSet = getUniqueRandoms(5, 10);
        System.out.println(uniqueRandomSet);
    }
}
