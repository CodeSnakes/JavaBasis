package Concurrent.threadsafety.callables;

import Concurrent.threadsafety.services.AtomicCounter;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-22:45
 */
public class AtomicCounterCallable implements Callable<Integer> {

  private final AtomicCounter counter;

  public AtomicCounterCallable(AtomicCounter counter) {
    this.counter = counter;
  }

  @Override
  public Integer call() throws Exception {
    counter.incrementCounter();
    return counter.getCounter();
  }
}
