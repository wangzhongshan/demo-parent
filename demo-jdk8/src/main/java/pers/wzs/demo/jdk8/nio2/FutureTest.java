package pers.wzs.demo.jdk8.nio2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            while (true) {
                System.out.println("哈哈哈哈");
                Thread.sleep(1000);
            }
        });
        Thread t1 = new Thread(futureTask);
        t1.start();

        Thread.sleep(5000);
        try {
            futureTask.get(100, TimeUnit.MICROSECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            futureTask.cancel(true);
        }

        Thread.sleep(5000);

//        t1.join();
    }
}
