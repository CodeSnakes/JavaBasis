package Concurrent.runnable;

import Other.Main;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yichangkong
 * @create 2020-08-09-16:25
 */
public class TaskRunner {
  private static ExecutorService executorService;

  public static void main(String[] args) {
      executorTask();
  }

  private static void executorTask() {
    executorService = Executors.newSingleThreadExecutor();

    EventLoggingTask task = new EventLoggingTask();
    Future future = executorService.submit(task);
    executorService.shutdown();
  }
}
