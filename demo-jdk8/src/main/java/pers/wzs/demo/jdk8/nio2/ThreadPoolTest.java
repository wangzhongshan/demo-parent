package pers.wzs.demo.jdk8.nio2;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<?> future1 = pool.submit(() -> {
            while (true) {
                System.out.println("哈哈哈哈");
                Thread.sleep(1000);
            }
        });

        Future<?> future2 = pool.submit(() -> {
            while (true) {
                System.out.println("fwfwew");
                Thread.sleep(1000);
            }
        });

        Thread.sleep(3000);

        try {
            future1.get(100, TimeUnit.MICROSECONDS);
        } catch (ExecutionException e) {
        } catch (TimeoutException e) {
            e.printStackTrace();
            future1.cancel(true);
        }
    }
}
