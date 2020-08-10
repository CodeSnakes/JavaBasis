package Concurrent.threadsafety.callables;

import Concurrent.threadsafety.services.Counter;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-22:50
 */
public class CounterCallable implements Callable<Integer> {
    private final Counter counter;

    public CounterCallable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
