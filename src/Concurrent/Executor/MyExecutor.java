package Concurrent.Executor;

import java.util.concurrent.Executor;

/**
 * @author yichangkong
 * @create 2020-08-05-21:45 Executor is an interface that represents an object that executes
 *     provided tasks.
 *     <p>It depends on the particular implementation (from where the invocation is initiated) if
 *     the task should be run on a new or current thread. Hence, using this interface, we can
 *     decouple the task execution flow from the actual task execution mechanism.
 *     <p>One point to note here is that Executor does not strictly require the task execution to be
 *     asynchronous. In the simplest case, an executor can invoke the submitted task instantly in
 *     the invoking thread.
 */
public class MyExecutor {
  public static void main(String[] args) {
    System.out.println("Begin execute");
    execute();
  }

  public static void execute() {
    Executor executor = new Invoker();
    executor.execute(
        () -> {
          // task to be performed 准备执行任务
          System.out.println("Hello Executor");
        });
  }
}

class Invoker implements Executor {
  // We need to create an invoker to create the executor instance:
  // 我们需要创建一个调用程序来创建执行程序实例：
  @Override
  public void execute(Runnable runnable) {
    runnable.run();
  }
}
