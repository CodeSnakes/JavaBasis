package Concurrent.threadsafety.callables;

import Concurrent.threadsafety.services.ReentrantReadWriteLockCounter;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-23:01
 */
public class ReentrantReadWriteLockCounterCallable implements Callable<Integer> {
    private final ReentrantReadWriteLockCounter counter;

    public ReentrantReadWriteLockCounterCallable(ReentrantReadWriteLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
