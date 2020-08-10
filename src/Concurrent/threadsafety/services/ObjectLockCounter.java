package Concurrent.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:15
 * ��������������
 */
public class ObjectLockCounter {
  private int counter; // ��ʼֵ0

  private final Object lock = new Object(); // ������

  public ObjectLockCounter() {
    this.counter = 0;
  }

  public void incrementCounter() {
    synchronized (lock) {
      counter += 1;
    }
  }

    public int getCounter() {
      synchronized (lock){
          return counter;
      }
    }
}
