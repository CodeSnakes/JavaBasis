package Concurrent.future;
import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-08-08-23:06
 *     <p>Future\ is used to represent the result of an asynchronous operation.
 *     <p>用于表示异步操作的结果
 */
public class FutureDemo {

  public String invoker(){
      String str =null;
      ExecutorService executorService = Executors.newFixedThreadPool(10);

      Future<String> future =executorService.submit(()->{
         //Task 任务
          Thread.sleep(10000l);
          return "Hello World";
      });

      future.cancel(false);//取消

      try{
          future.get(20, TimeUnit.SECONDS);
      }catch (InterruptedException| ExecutionException |TimeoutException e1){
          e1.printStackTrace();
      }

      if (future.isDone()&&!future.isCancelled()){
          try{
              str = future.get();
          }catch (InterruptedException|ExecutionException e){
              e.printStackTrace();
          }
      }

      return str;
  }

}
