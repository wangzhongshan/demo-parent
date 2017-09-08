package pers.wzs.demo.jdk8.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class IdeaTest {
    private static final Set<String> AAAS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("feee", "feee", "fefwe")));

    public static void main(String[] args) {
        String aaa = "fff";
        if (AAAS.contains(aaa)) {
            System.out.println("哈哈");
        }

        Stream<String> stringStream = Stream.of("234", "fwejio", "eeee", "eejiii", "ff");
        long count = stringStream.filter(s -> s.startsWith("ee")).count();
        System.out.println(count);
    }
}
