package Concurrent.Cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author yichangkong
 * @create 2020-08-09-16:09
 *     <p>CyclicBarrier works almost the same as CountDownLatch except that we can reuse it.
 *     <p>XX�Ĺ��ܼ�����XXX��ͬ���������ǿ����ظ�ʹ����
 *     <p>Unlike CountDownLatch, it allows multiple threads to wait for each other using await()
 *     method(known as barrier condition) before invoking the final task.
 *     <p>����XXX �ڵ������յ�����֮ǰ�����������߳�ʹ��await������������ȴ�����Ϊ����������
 *     <p>դ�������ڱ�������������һ���߳�ֱ��ĳ���¼��ķ�����դ��������Ĺؼ��������ڣ�
 *     ���е��̱߳���ͬʱ����դ��λ�ã����ܼ���ִ�С�
 *     �������ڵȴ��¼�����դ�����ڵȴ������̡߳�
 */
public class CyclicBarrierExample {
  public static void start() {
    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            3,
            () -> {
              // Task
              System.out.println("All previous task are completed");
            });
    Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
    Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
    Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

//      Here, the isBroken() method checks if any of the threads got interrupted during the execution time.
//      We should always perform this check before performing the actual process.
//      isBroken�������������ִ���ڼ��Ƿ����κ��̱߳��жϡ���ִ��ʵ�ʹ���֮ǰ������Ӧʼ��ִ�д˼�顣
    if (!cyclicBarrier.isBroken()) {

      t1.start();
      t2.start();
      t3.start();
    }
  }

  public static void main(String[] args) {
      start();
  }
}
