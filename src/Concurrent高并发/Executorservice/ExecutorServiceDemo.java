package Concurrent高并发.Executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yichangkong
 * @create 2020-08-08-21:40
 */
public class ExecutorServiceDemo {

  ExecutorService executorService = Executors.newFixedThreadPool(10); // 创建10线程

  public void executor() {
    executorService.submit(
        () -> {
          new Task();
        }); // 开始提交任务
    executorService.shutdown(); // 无返回
    executorService.shutdownNow(); // 返回List<Runnable>
    try {
      executorService.awaitTermination(201, TimeUnit.NANOSECONDS);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
