package Concurrent.threadsafety.application;

import Concurrent.threadsafety.callables.*;
import Concurrent.threadsafety.mathutils.MathUtils;
import Concurrent.threadsafety.services.*;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author yichangkong
 * @create 2020-08-09-17:27
 */
public class Application {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // �������߳�
    new Thread(
            () -> {
              System.out.println(MathUtils.factorial(10));
            })
        .start();
    new Thread(
            () -> {
              System.out.println(MathUtils.factorial(5));
            })
        .start();

    ExecutorService executorService = Executors.newFixedThreadPool(10); // ִ�������� 10�߳�

    // --------------1----------------
    MessageService messageService = new MessageService("Welcome to Baeldung!");
    Future<String> future1 =
        (Future<String>)
            executorService.submit(new MessageServiceCallable(messageService)); // ���ڱ�ʾ�첽�����Ľ��
    Future<String> future2 =
        (Future<String>) executorService.submit(new MessageServiceCallable(messageService));

    System.out.println(future1.get()); // ʹ��get���� ���exception  getʲô�أ�����
    System.out.println(future2.get());

    // --------------2----------------
    Counter counter = new Counter(); // ���� ��ʼֵΪ0
    Future<Integer> future3 =
        (Future<Integer>) executorService.submit(new CounterCallable(counter));
    Future<Integer> future4 =
        (Future<Integer>) executorService.submit(new CounterCallable(counter));

    System.out.println(future3.get());
    System.out.println(future4.get());

    // -------------3-----------------
    ObjectLockCounter objectLockCounter = new ObjectLockCounter(); // ������������
    Future<Integer> future5 =
        executorService.submit(new ExtrinsicLockCounterCallable(objectLockCounter));
    Future<Integer> future6 =
        executorService.submit(new ExtrinsicLockCounterCallable(objectLockCounter));

    System.out.println(future5.get());
    System.out.println(future6.get());

    // -------------4-----------------

    ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter(); // ������������

    Future<Integer> future7 =
        executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
    Future<Integer> future8 =
        executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
    System.out.println(future7.get());
    System.out.println(future8.get());

    // -------------5-----------------

    ReentrantReadWriteLockCounter reentrantReadWriteLockCounter =
        new ReentrantReadWriteLockCounter(); // �����д������
    Future<Integer> future9 =
        (Future<Integer>)
            executorService.submit(
                new ReentrantReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
    Future<Integer> future10 =
        (Future<Integer>)
            executorService.submit(
                new ReentrantReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
    System.out.println(future9.get());
    System.out.println(future10.get());

    // -------------6-----------------
    AtomicCounter atomicCounter = new AtomicCounter(); // ԭ�Ӽ���
    Future<Integer> future11 =
        (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
    Future<Integer> future12 =
        (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
    System.out.println(future11.get());
    System.out.println(future12.get());

    // -------------7-----------------
    Collection<Integer> syncCollection =
        Collections.synchronizedCollection(new ArrayList<>()); // ͬ�����ϣ�����

    Thread thread11 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Thread thread12 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));

    Map<String, String> concurrentMap = new ConcurrentHashMap<>();
    concurrentMap.put("1", "one");
    concurrentMap.put("2", "two");
    concurrentMap.put("3", "three");
  }
}
