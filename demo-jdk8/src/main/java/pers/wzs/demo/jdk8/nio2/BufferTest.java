package pers.wzs.demo.jdk8.nio2;

import java.nio.CharBuffer;

/**
 * Created by wangzhongshan on 2017/9/8.
 */
public class BufferTest {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println(buffer.capacity());
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        buffer.flip();
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.position());
        buffer.clear();
        System.out.println(buffer.limit());
    }
}
