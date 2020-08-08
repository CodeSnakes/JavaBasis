package Concurrent.future;

import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-08-06-22:50
 */
public class MyFuture {

  static String str;

  public static void main(String[] args) {

  }

  // We can use below code snippet��Ƭ�Σ� to create a future instance:
  // ����Ĵ����
  public static void invokes() {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    Future<String> future =
        executorService.submit(
            () -> {
              // ...
              Thread.sleep(10000l);
              return "Hello world";
            });

    // We can use following code snippet to check if the future result is ready and fetch the data
    // if the computation is done:
    // ���ǿ���ʹ�����´���Ƭ������齫���Ľ���Ƿ�׼�����������ڼ�����ɺ��ȡ����
    if (future.isDone() && !future.isCancelled()) {
      try {
        str = future.get();
        System.out.println(str);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    // We can also specify a timeout for a given operation.
    // ���ǻ�����Ϊ��������ָ��һ����ʱ
    // If the task takes more than this time, a TimeoutException is thrown:
    try {
      future.get(10, TimeUnit.SECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    }
  }
}
