package pers.wzs.demo.jdk8.collection;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by wangzhongshan on 2017/6/21.
 */
public class StreamDemo {
    public static void main(String[] args) {
        //test collect list to string
        /*StringBuffer stringBuffer = Stream.of(211, 223, 1134, 1134, 11166, 66).collect(StringBuffer::new,
                (x, y) -> {
                    if (x.length() == 0) {
                        x.append(y);
                    } else {
                        x.append("," + y);
                    }
                }, (x, y) -> {
                    if (x.length() == 0) {
                        x.append(y);
                    } else {
                        x.append(",").append(y);
                    }
                });
        System.out.println(stringBuffer.toString());*/

        // StringJoiner stringJoiner = Stream.of(211, 223, 1134, 1134, 11166, 66).collect(
        //         () -> new StringJoiner(","), (x, y) -> x.add("" + y), (x, y) -> x.merge(y)
        // );
        // System.out.println(stringJoiner.toString());
        HashMap<Integer, Integer> userCountMap = new HashMap<>();
        userCountMap.put(1, 22);
        userCountMap.put(2, 12);
        userCountMap.put(3, 2);
        userCountMap.put(4, 23);
        Optional<Map.Entry<Integer, Integer>> min = userCountMap.entrySet()
                                                                .stream()
                                                                .min(Comparator.comparing(Map.Entry::getValue));
        System.out.println(min.get());
        Map.Entry<Integer, Integer> min1 = Collections.min(userCountMap.entrySet(), Comparator.comparing(Map.Entry::getValue));
        System.out.println(min1);

    }
}
