package Concurrent.stopping;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yichangkong
 * @create 2020-08-09-16:55
 */
public class ControlSubThread implements Runnable {

  private Thread worker;
  private int interval = 100;
  // 原子性布尔值操作
  private AtomicBoolean running = new AtomicBoolean(false);
  private AtomicBoolean stopped = new AtomicBoolean(true);

  public ControlSubThread(int interval) {
    this.interval = interval;
  }

  public void start() {
    worker = new Thread(this);
    worker.start();
  }

  public void stop() {
    running.set(false);
  }

  public void interrupt() {
    running.set(false);
    worker.interrupt();
  }

  @Override
  public void run() {
    running.set(true);
    stopped.set(false);
    while (running.get()) {
      try {
          Thread.sleep(interval);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread was interrupted, Failed to complete operation");
      }
      //do something
    }
    stopped.set(true);
  }
}
