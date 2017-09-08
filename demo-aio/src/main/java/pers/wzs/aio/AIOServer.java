package pers.wzs.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhongshan on 2017/7/18.
 */
public class AIOServer {
    public static final int port = 30000;
    private AsynchronousServerSocketChannel serverChannel;
    private List<AsynchronousSocketChannel> channels = new ArrayList<>();

    public void startListen() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        AsynchronousChannelGroup asynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(asynchronousChannelGroup);
        serverChannel = serverSocketChannel;
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel sc, Object attachment) {
                channels.add(sc);
                serverChannel.accept(null, this);
                sc.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        byteBuffer.flip();
                        String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();
                        for (AsynchronousSocketChannel channel : channels) {
                            try {
                                channel.write(ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8))).get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        byteBuffer.clear();
                        sc.read(byteBuffer, null, this);
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("读取数据上失败：" + exc.getMessage());
                        channels.remove(sc);
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("链接失败：" + exc.getMessage());
            }
        });
    }

    public static void main(String[] args) throws IOException {
        AIOServer aioServer = new AIOServer();
        aioServer.startListen();
    }
}
