package Concurrent.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yichangkong
 * @create 2020-08-06-14:01
 */
public class MyExecutorService {
  // To specify the thread-pool size.
  static ExecutorService executor = Executors.newFixedThreadPool(10);

  public static void main(String[] args) {
    executor();
  }

  public static void executor() {
    executor.submit(new Task());
    executor.submit(() -> new TaskForRunnable());

//    try {
//      executor.awaitTermination(20L, TimeUnit.NANOSECONDS);
//      System.out.println("Termination");
//    } catch (InterruptedException ex) {
//      ex.printStackTrace();
//    }
  }
}

class Task implements Runnable {
  @Override
  public void run() {
    // task detailsÏ¸½Ú
    System.out.println("Run TasK");
  }
}

class TaskForRunnable implements Runnable {
  @Override
  public void run() {
    // task detailsÏ¸½Ú
    System.out.println("Runnable TasK");
  }
}
