package Concurrent高并发.threadsafety.callables;

import Concurrent高并发.threadsafety.services.ReentrantLockCounter;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-23:15
 */
public class ReentrantLockCounterCallable implements Callable<Integer> {

    private final ReentrantLockCounter counter;

    public ReentrantLockCounterCallable(ReentrantLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
