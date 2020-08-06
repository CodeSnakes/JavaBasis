package Concurrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/**
 * @author yichangkong
 * @create 2020-08-06-23:23
 */
public class MyCyclicBarrier {

  static  Logger LOG = Logger.getLogger("LOG1");
  public static void main(String[] args) {

      CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        // ...
        LOG.info("All previous tasks are completed");
      });

      Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
      Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
      Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

      if (!cyclicBarrier.isBroken()) {
        t1.start();
        t2.start();
        t3.start();
      }

  }
}

class Task implements Runnable {
  private CyclicBarrier barrier;

  Logger LOG = Logger.getLogger("LOG1");

  public Task(CyclicBarrier barrier) {
    this.barrier = barrier;
  }


  @Override
  public void run() {
    try {

      LOG.info(Thread.currentThread().getName() + " is waiting");
      barrier.await();
      LOG.info(Thread.currentThread().getName() + " is released");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }


}
