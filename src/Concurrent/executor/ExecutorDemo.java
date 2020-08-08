package Concurrent.executor;

import Other.Main;

import java.util.concurrent.Executor;

/**
 * @author yichangkong
 * @create 2020-08-08-21:24
 * Executor is an interface that represents an object that executes
 *     provided tasks.
 *   Executor 是一个代表执行提供任务的一个接口对象
 */
public class ExecutorDemo {
  public static void main(String[] args) {
    execute();
  }

  static public void execute(){
       Executor executor = (Executor) new  Invoker();
    executor.execute(
        () -> {
          System.out.println("Hello Executor");
        });
   }
}
