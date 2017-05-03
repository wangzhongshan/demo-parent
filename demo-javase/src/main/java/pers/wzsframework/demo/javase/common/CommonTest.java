package pers.wzsframework.demo.javase.common;

import java.util.Map;

/**
 * Created by wangzhongshan on 2017/4/7.
 */
public class CommonTest {
    public static void main(String[] args) {
        RedisClient redisClient = new RedisClient("live1");
        RedisClient redisClient2 = new RedisClient("live2");
        RedisClient redisClient3 = new RedisClient("live3");
        RedisClient redisClient4 = new RedisClient("live1");
        System.out.println(redisClient.getPool()==redisClient4.getPool());
        Map<String, Pool> pools = redisClient.getPools();
        Map<String, Pool> pools2 = redisClient2.getPools();
        Map<String, Pool> pools3 = redisClient3.getPools();
        Map<String, Pool> pools4 = redisClient4.getPools();
        System.out.println("");
    }
}
