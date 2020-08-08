package Concurrent.executor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-08-05-22:11
 *
 * Executor �� ExecutorService �������ӿ���Ҫ�������ǣ�
 * ExecutorService �ӿڼ̳��� Executor �ӿڣ��� Executor ���ӽӿ� Executor �� ExecutorService
 * �ڶ��������ǣ�
 *  Executor �ӿڶ����� execute()������������һ��Runnable�ӿڵĶ��󣬶� ExecutorService �ӿ��е�
 * submit()�������Խ���Runnable��Callable�ӿڵĶ��� Executor �� ExecutorService �ӿ�
 *
 * ������������
 *  Executor �е� execute() �����������κν������ ExecutorService �е�
 *  submit()��������ͨ��һ�� Future ���󷵻���������
 *  Executor �� ExecutorService �ӿ�
 *
 * ���ĸ�������
 *  ��������ͻ����ύһ������ExecutorService ���ṩ���������̳߳صķ�����
 *  ���磺���� shutDown() ������ֹ�̳߳ء�����ͨ�� ��Java Concurrency in Practice��
 *  һ���˽������ڹر��̳߳غ���δ��� pending �������֪ʶ��
 *  Executors ���ṩ������������������ͬ���͵��̳߳ء�����: newSingleThreadExecutor()
 *  ����һ��ֻ��һ���̵߳��̳߳أ�newFixedThreadPool(int numOfThreads)
 *  �������̶��߳������̳߳أ�newCachedThreadPool()���Ը�����Ҫ�����µ��̣߳�����������߳��ǿ��еĻ����������̡߳�
 */
public class CallableDemo {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();
    List<Future<String>> resultList = new ArrayList<Future<String>>();

    // ����10������ִ��
    for (int i = 0; i < 10; i++) {
      // ʹ��ExecutorServiceִ��Callable���͵����񣬲������������future������
      Future<String> future = executorService.submit(new TaskWithResult(i));
      // ������ִ�н���洢��List��
      resultList.add(future);
    }

    // ��������Ľ��
    for (Future<String> fs : resultList) {
      try {
        while (!fs.isDone()) ; // Future�������û����ɣ���һֱѭ���ȴ���ֱ��Future�������
        System.out.println(fs.get()); // ��ӡ�����̣߳�����ִ�еĽ��
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } finally {
        // ����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������
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

  /** ����ľ�����̣�һ�����񴫸�ExecutorService��submit������ ��÷����Զ���һ���߳���ִ�� */
  public String call() throws Exception {
    System.out.println("call()�������Զ����ã�����    " + Thread.currentThread().getName());
    // �÷��ؽ������Future��get�����õ�
    return "call()�������Զ����ã����񷵻صĽ���ǣ�" + id + "    " + Thread.currentThread().getName();
  }
}
