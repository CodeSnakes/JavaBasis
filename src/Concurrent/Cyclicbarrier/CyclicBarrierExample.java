package Concurrent.Cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author yichangkong
 * @create 2020-08-09-16:09
 *     <p>CyclicBarrier works almost the same as CountDownLatch except that we can reuse it.
 *     <p>XX的功能几乎和XXX相同，除了我们可以重复使用他
 *     <p>Unlike CountDownLatch, it allows multiple threads to wait for each other using await()
 *     method(known as barrier condition) before invoking the final task.
 *     <p>不像XXX 在调用最终的任务之前，它允许多个线程使用await（）方法互相等待（称为屏障条件）
 *     <p>栅栏类似于闭锁，它能阻塞一组线程直到某个事件的发生。栅栏与闭锁的关键区别在于，
 *     所有的线程必须同时到达栅栏位置，才能继续执行。
 *     闭锁用于等待事件，而栅栏用于等待其他线程。
 */
public class CyclicBarrierExample {
  public static void start() {
    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            3,
            () -> {
              // Task
              System.out.println("All previous task are completed");
            });
    Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
    Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
    Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

//      Here, the isBroken() method checks if any of the threads got interrupted during the execution time.
//      We should always perform this check before performing the actual process.
//      isBroken（）方法检查在执行期间是否有任何线程被中断。在执行实际过程之前，我们应始终执行此检查。
    if (!cyclicBarrier.isBroken()) {

      t1.start();
      t2.start();
      t3.start();
    }
  }

  public static void main(String[] args) {
      start();
  }
}
