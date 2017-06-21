package pers.wzs.demo.jdk8.collection;

import java.util.StringJoiner;
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

        StringJoiner stringJoiner = Stream.of(211, 223, 1134, 1134, 11166, 66).collect(
                () -> new StringJoiner(","), (x, y) -> x.add("" + y), (x, y) -> x.merge(y)
        );
        System.out.println(stringJoiner.toString());
    }
}
