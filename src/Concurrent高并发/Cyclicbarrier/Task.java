package Concurrent¸ß²¢·¢.Cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yichangkong
 * @create 2020-08-09-16:10
 */
public class Task implements Runnable {

  private CyclicBarrier barrier;

  public Task(CyclicBarrier barrier) {
    this.barrier = barrier;
  }

  @Override
  public void run() {
    try {
      System.out.println("Thread : " + Thread.currentThread().getName() + "is waiting");
      barrier.await();
      System.out.println("Thread : " + Thread.currentThread().getName() + "is released");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
