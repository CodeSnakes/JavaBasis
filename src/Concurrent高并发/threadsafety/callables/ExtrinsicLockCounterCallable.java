package Concurrent高并发.threadsafety.callables;

import Concurrent高并发.threadsafety.services.ObjectLockCounter;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-22:57
 * 外部锁 Extrinsic Lock
 */
public class ExtrinsicLockCounterCallable implements Callable<Integer> {
    private final ObjectLockCounter counter;

    public ExtrinsicLockCounterCallable(ObjectLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
