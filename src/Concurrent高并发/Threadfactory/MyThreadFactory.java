package Concurrent¸ß²¢·¢.Threadfactory;

import javafx.concurrent.Task;

import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

/**
 * @author yichangkong
 * @create 2020-08-08-16:50
 */
public class MyThreadFactory {
  public static void main(String[] args) {
    //
      BaeldungThreadFactorys factory = new BaeldungThreadFactorys(
              "BaeldungThreadFactory");
      for (int i = 0; i < 10; i++) {
          Thread t = factory.newThread(new Task() {
              @Override
              protected Object call() throws Exception {
                  return null;
              }
          });
          t.start();
      }
  }
}

class BaeldungThreadFactorys implements ThreadFactory {

  Logger LOG = Logger.getLogger("BaeldungThreadFactory");

  private int threadId;
  private String name;

  public BaeldungThreadFactorys(String name) {
    threadId = 1;
    this.name = name;
  }

  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread(r, name + "-Thread_" + threadId);
    LOG.info("created new thread with id : " + threadId + " and name : " + t.getName());
    threadId++;
    return t;
  }
}
