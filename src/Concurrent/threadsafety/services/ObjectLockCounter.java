package Concurrent.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:15
 * 对象锁定计数器
 */
public class ObjectLockCounter {
  private int counter; // 初始值0

  private final Object lock = new Object(); // 锁对象

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
