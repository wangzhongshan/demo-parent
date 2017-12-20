package pers.wzs.demo.jdk8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhongshan on 2017/12/4.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Long> gids = new ArrayList<>();
        gids.add(1L);
        gids.add(2L);
        gids.add(3L);
        gids.add(4L);
        String[] strings = gids.stream().distinct().map(String::valueOf).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}
