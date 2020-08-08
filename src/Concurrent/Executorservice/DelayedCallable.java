package Concurrent.Executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author yichangkong
 * @create 2020-08-08-21:40 DelayedCallable �ӳٺ���
 */
public class DelayedCallable implements Callable<String> {

  private String name;
  private long period; // ����
  private CountDownLatch latch; // ��������
  /**
   * CountDownLatch (introduced in JDK 5) is a utility class which blocks a set of threads until
   * some operation completes.
   * <p>һ��ʵ�ó����࣬������ֹһ���̣߳�ֱ�����ĳЩ����Ϊֹ��
   *
   */
  public DelayedCallable(String name, long period, CountDownLatch latch) {
    this(name, period);
    this.latch = latch;
  }

  DelayedCallable(String name, long period) {
    this.name = name;
    this.period = period;
  }

  @Override
  public String call() throws Exception {
    try {
      Thread.sleep(period);

      if (latch != null) {
        latch.countDown();
      }

    } catch (InterruptedException ex) {
      ex.printStackTrace();
      Thread.currentThread().interrupt();
    }
    return name;
  }
}
