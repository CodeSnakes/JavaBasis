package Concurrent.Scheduled;

import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-08-06-21:56
 * Scheduled Ê±¼ä±í
 */
public class MyScheduled {

  public static void main(String[] args) {
    //
  }

    public void execute() {
        // We can use both *Runnable* and *Callable* interface to define the task.
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executorService.schedule(() -> {
            // ...
            return "Hello world";
        }, 1, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
            // ...
        }, 1, TimeUnit.SECONDS);

        // ScheduledExecutorService can also schedule the task after some given fixed delay:
        executorService.scheduleAtFixedRate(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
