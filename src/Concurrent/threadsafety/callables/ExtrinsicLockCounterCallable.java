package Concurrent.threadsafety.callables;

import Concurrent.threadsafety.services.ObjectLockCounter;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-22:57
 * Íâ²¿Ëø Extrinsic Lock
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
