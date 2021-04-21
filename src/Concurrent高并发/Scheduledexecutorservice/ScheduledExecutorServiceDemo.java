package Concurrent�߲���.Scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author yichangkong
 * @create 2020-08-06-21:56 Scheduled Ԥ�� ScheduledExecutorService (��ʱ���Ȼ���)is a similar interface to
 *     ExecutorService, but it can perform tasks periodically.
 *     <p>xxx��������ִ���������һ���ӿڣ��������ɶ���ִ������So you know that
 */
public class ScheduledExecutorServiceDemo {

  public String execute() {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    String str = getTasksToRun().apply(executorService);
    executorService.shutdown();
    return str;
  }

  public void executorWithMultiThread() {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    getTasksToRun().apply(executorService);
    executorService.shutdown();
  }

  private Function<ScheduledExecutorService, String> getTasksToRun() {
    return (ExecutorService -> {
      ScheduledFuture<?> scheduledFuture1 = ExecutorService.schedule(() -> {}, 1, TimeUnit.SECONDS);
      ScheduledFuture<?> scheduledFuture2 =
          ExecutorService.scheduleAtFixedRate(() -> {}, 1, 10, TimeUnit.SECONDS);
      ScheduledFuture<?> scheduledFuture3 =
          ExecutorService.scheduleWithFixedDelay(() -> {}, 1, 10, TimeUnit.SECONDS);
      ScheduledFuture<?> scheduledFuture4 =
          ExecutorService.schedule(
              () -> {
                return "Hello World";
              },
              1,
              TimeUnit.SECONDS);
      return "Nothing";
    });
  }

  public static void main(String[] args) {
    ScheduledExecutorServiceDemo scheduledExecutorServiceDemo = new ScheduledExecutorServiceDemo();
    String str = scheduledExecutorServiceDemo.execute();
    scheduledExecutorServiceDemo.executorWithMultiThread();
    System.out.println(str);
  }
}
