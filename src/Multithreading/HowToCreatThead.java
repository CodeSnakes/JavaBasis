package Multithreading;

import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-07-11-16:31
 */
public class HowToCreatThead {
  static class MyThread extends Thread {
    @Override
    public void run() {
      System.out.println("Hello MyThead!");
    }
  }

  static class MyRun implements Runnable {
    @Override
    public void run() {
      System.out.println("Hello MyRun!");
    }
  }

  static class MyCall implements Callable<String> {
    @Override
    public String call() throws Exception {
      System.out.println("Hello MyCall");
      return "success";
    }
  }

  public static void main(String[] args) {
    // five ways to start threads
    // 启动线程的5种方式
    new MyThread().start();
    new Thread(new MyRun()).start();
    new Thread(
        () -> {
          System.out.println("Hello Lambda!");
        }).start();

    Thread t = new Thread(new FutureTask<String>(new MyCall()));
    t.start();

      ExecutorService service = Executors.newCachedThreadPool();
    service.execute(
        () -> {
          System.out.println("Hello ThreadPool");
        });
    service.shutdown();
  }
}
