package Concurrent.threadsafety.services;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yichangkong
 * @create 2020-08-10-15:29
 */
public class AtomicCounter {
  private final AtomicInteger counter = new AtomicInteger();

  public AtomicCounter() {}

  public void incrementCounter() {
      counter.incrementAndGet();
  }

  public synchronized int getCounter() {
    return counter.get();
  }
}
