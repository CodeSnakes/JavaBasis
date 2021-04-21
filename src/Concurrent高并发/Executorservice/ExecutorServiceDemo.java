package Concurrent�߲���.Executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yichangkong
 * @create 2020-08-08-21:40
 */
public class ExecutorServiceDemo {

  ExecutorService executorService = Executors.newFixedThreadPool(10); // ����10�߳�

  public void executor() {
    executorService.submit(
        () -> {
          new Task();
        }); // ��ʼ�ύ����
    executorService.shutdown(); // �޷���
    executorService.shutdownNow(); // ����List<Runnable>
    try {
      executorService.awaitTermination(201, TimeUnit.NANOSECONDS);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
