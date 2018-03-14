package com.future.account.service.utils;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.ValueOperations;

/**
 * 基于redis的分布式锁
 * @author caojia
 *
 */
public class RedisLock {
    
    static Logger logger = Logger.getLogger(RedisLock.class);
    
    private ValueOperations<String, String> valueOperations;
    
    private final static int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 5;
    
    private final static String REDIS_LOCK_KEY_SUFFIX = "-redis-lock-key";
    
    private String lockKey;
    
    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private long expireMsecs = 10 * 1000;
    
    /**
     * 锁等待时间，防止线程饥饿
     */
    private long timeoutMsecs = 10 * 1000;
    
    private volatile boolean locked = false;
    
    public RedisLock(ValueOperations<String, String> valueOperations, String key){
        this.valueOperations = valueOperations;
        this.lockKey = key + REDIS_LOCK_KEY_SUFFIX;
    }
    
    public RedisLock(ValueOperations<String, String> valueOperations, String key, long timeoutMsecs){
        this(valueOperations, key);
        this.timeoutMsecs = timeoutMsecs;
    }
    
    public RedisLock(ValueOperations<String, String> valueOperations, String key, long timeoutMsecs, long expireMsecs){
        this(valueOperations, key, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }
    
    private String get(final String key) {
        
        String value = null;
        try {
            value = valueOperations.get(key);
        } catch (Exception e) {
            logger.error("获取锁失败", e);
        }
        
        return value;
    }
    
    private boolean setNX(final String key, final String value) {
        
        boolean flag = false;
        
        try {
            flag = valueOperations.setIfAbsent(key, value);
        } catch (Exception e) {
            logger.error("设置锁失败", e);
        }
        
        return flag;
    }

    private String getSet(final String key, final String value) {
        
        String oldValue = null;
        try {
            oldValue = valueOperations.getAndSet(key, value);
        } catch (Exception e) {
            logger.error("获取锁失败",e);
        }
        return oldValue;
    }
    
    public boolean lock() throws InterruptedException {
        
        long timeout = timeoutMsecs;
        while(timeout > 0) {
            //分布式环境下系统时间不一致，需要一个时间服务器
            long expire = System.currentTimeMillis() + expireMsecs + 1;//锁到期时间
            String expireStr = String.valueOf(expire);
            if(this.setNX(lockKey, expireStr)){
                // lock acquired
                locked = true;
                return true;
            }
            
            String currentValueStr = this.get(lockKey);//redis里的时间
            if(currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                
                String oldValueStr = this.getSet(lockKey, expireStr);
                if(oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    
                    locked = true;
                    return true;
                }
                
            }
            
            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            /**
             *   延迟100 毫秒,  这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
             *   只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
             *   使用随机的等待时间可以一定程度上保证公平性
             */
            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
        }
        
        return false;
    }
    
    public void unlock() {
        
        if (locked) {
            valueOperations.set(lockKey, null);
            locked = false;
        }
        
    }
}
