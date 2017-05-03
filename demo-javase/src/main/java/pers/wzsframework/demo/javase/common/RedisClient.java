package pers.wzsframework.demo.javase.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhongshan on 2017/4/25.
 */
@Data
public class RedisClient {
    private static Map<String, Pool> pools = new HashMap<>();
    private Pool pool;
    public RedisClient(String name) {
        this.pool = getPool(name);
    }

    private Pool getPool(String name) {
        Pool pool = pools.get(name);
        if (pool != null) {
            return pool;
        }
        Pool poolNew = new Pool();
        pools.put(name, poolNew);
        return poolNew;
    }

    public Map<String, Pool> getPools() {
        return pools;
    }
}
