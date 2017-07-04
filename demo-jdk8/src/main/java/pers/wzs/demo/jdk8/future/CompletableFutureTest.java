package pers.wzs.demo.jdk8.future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by wangzhongshan on 2017/6/22.
 */
public class CompletableFutureTest {

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int i = 1/0;
//            return 100;
//        });
//future.join();
////        future.get();

//        final CompletableFuture<Integer> f = compute();
//        class Client extends Thread {
//            CompletableFuture<Integer> f;
//
//            Client(String threadName, CompletableFuture<Integer> f) {
//                super(threadName);
//                this.f = f;
//            }
//
//            @Override
//            public void run() {
//                try {
//                    System.out.println(this.getName() + ": " + f.get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        new Client("Client1", f).start();
//        new Client("Client2", f).start();
//        System.out.println("waiting");
//        Thread.sleep(5000);
////        f.complete(100);
//        f.completeExceptionally(new Exception());
//        System.in.read();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::getMoreData);
//        CompletableFuture<Integer> whenComplete = future.whenComplete((v, e) -> {
//            System.out.println("return value =" + v);
//            System.out.println("return exception= " + e);
//        });
//        System.out.println(whenComplete.get());

        future.thenAccept(x -> System.out.println("回调参数：" + x));

        System.in.read();


    }

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(3000);
//            if (1 == 1) {
//                throw new RuntimeException("测试异常返回");
//            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        return rand.nextInt(1000);
    }
}
