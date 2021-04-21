package Concurrent高并发.threadsafety.services;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yichangkong
 * @create 2020-08-10-22:19
 * 重入锁计数器
 */
public class ReentrantLockCounter {
    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);

    public ReentrantLockCounter() {
        this.counter = 0;
    }
    public void incrementCounter(){
        reLock.lock();
        try{
            counter +=1;
        }finally{
            reLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}
