package Concurrent高并发.Cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

/**
 * @author yichangkong
 * @create 2020-08-06-23:23
 * 屏障机制
 */
public class MyCyclicBarrier {

  static  Logger LOG = Logger.getLogger("LOG1");
  public static void main(String[] args) {

      CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        LOG.info("All previous tasks are completed");//之前的所有任务均已完成
      });

      Thread t1 = new Thread(new Tasks(cyclicBarrier), "T1");
      Thread t2 = new Thread(new Tasks(cyclicBarrier), "T2");
      Thread t3 = new Thread(new Tasks(cyclicBarrier), "T3");

      if (!cyclicBarrier.isBroken()) {
        t1.start();
        t2.start();
        t3.start();
      }

  }
}
    /**
     * We need to create a *Runnable* task instance to initiate the barrier condition:
     * 启动屏障时我们需要创建一个XXX任务实例
     **/
class Tasks implements Runnable {
  private CyclicBarrier barrier;

  Logger LOG = Logger.getLogger("LOG1");

  public Tasks(CyclicBarrier barrier) {
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
