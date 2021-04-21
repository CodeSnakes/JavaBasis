package Concurrent¸ß²¢·¢.Threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author yichangkong
 * @create 2020-08-09-17:19
 */
public class BaeldungThreadFactory implements ThreadFactory {

  private int threadId;
  private String name;

  public BaeldungThreadFactory(String name) {
    this.threadId = 1;
    this.name = name;
  }

  @Override
  public Thread newThread(Runnable runnable) {
    Thread t = new Thread(runnable, name + "-Thread_" + threadId);
    System.out.println("created new thread with id: " + threadId + "and name :" + t.getName());
    threadId++;

    return t;
  }
}
