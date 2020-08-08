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

  // We can use below code snippet（片段） to create a future instance:
  // 下面的代码块
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
    // 我们可以使用以下代码片段来检查将来的结果是否准备就绪，并在计算完成后获取数据
    if (future.isDone() && !future.isCancelled()) {
      try {
        str = future.get();
        System.out.println(str);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    // We can also specify a timeout for a given operation.
    // 我们还可以为给定操作指定一个超时
    // If the task takes more than this time, a TimeoutException is thrown:
    try {
      future.get(10, TimeUnit.SECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    }
  }
}
