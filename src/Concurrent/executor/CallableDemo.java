package Concurrent.executor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-08-05-22:11
 *
 * Executor 和 ExecutorService 这两个接口主要的区别是：
 * ExecutorService 接口继承了 Executor 接口，是 Executor 的子接口 Executor 和 ExecutorService
 * 第二个区别是：
 *  Executor 接口定义了 execute()方法用来接收一个Runnable接口的对象，而 ExecutorService 接口中的
 * submit()方法可以接受Runnable和Callable接口的对象。 Executor 和 ExecutorService 接口
 *
 * 第三个区别是
 *  Executor 中的 execute() 方法不返回任何结果，而 ExecutorService 中的
 *  submit()方法可以通过一个 Future 对象返回运算结果。
 *  Executor 和 ExecutorService 接口
 *
 * 第四个区别是
 *  除了允许客户端提交一个任务，ExecutorService 还提供用来控制线程池的方法。
 *  比如：调用 shutDown() 方法终止线程池。可以通过 《Java Concurrency in Practice》
 *  一书了解更多关于关闭线程池和如何处理 pending 的任务的知识。
 *  Executors 类提供工厂方法用来创建不同类型的线程池。比如: newSingleThreadExecutor()
 *  创建一个只有一个线程的线程池，newFixedThreadPool(int numOfThreads)
 *  来创建固定线程数的线程池，newCachedThreadPool()可以根据需要创建新的线程，但如果已有线程是空闲的会重用已有线程。
 */
public class CallableDemo {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();
    List<Future<String>> resultList = new ArrayList<Future<String>>();

    // 创建10个任务并执行
    for (int i = 0; i < 10; i++) {
      // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
      Future<String> future = executorService.submit(new TaskWithResult(i));
      // 将任务执行结果存储到List中
      resultList.add(future);
    }

    // 遍历任务的结果
    for (Future<String> fs : resultList) {
      try {
        while (!fs.isDone()) ; // Future返回如果没有完成，则一直循环等待，直到Future返回完成
        System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } finally {
        // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
        executorService.shutdown();
      }
    }
  }
}

class TaskWithResult implements Callable<String> {
  private int id;

  public TaskWithResult(int id) {
    this.id = id;
  }

  /** 任务的具体过程，一旦任务传给ExecutorService的submit方法， 则该方法自动在一个线程上执行 */
  public String call() throws Exception {
    System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
    // 该返回结果将被Future的get方法得到
    return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
  }
}
