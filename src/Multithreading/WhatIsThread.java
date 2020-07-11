package Multithreading;

import java.util.concurrent.TimeUnit;

/**
 * @author yichangkong
 * @create 2020-07-11-16:17
 */
public class WhatIsThread {
  private static class T1 extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        // sleep 1
        try {
          TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
//          System.out.println("T1"+i);
        // Displaying the thread that is running
          System.out.println ("Thread " +
                  Thread.currentThread().getId() +
                  " is running");
      }
    }
  }

  public static void main(String[] args) {
    new T1().start();
    for (int i = 0; i < 10; i++) {
      //
      try {
        TimeUnit.MILLISECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Main Thread   "+Thread.currentThread().getId()+"  Is running");
    }
  }
  /*
  观察上面程序的数据结果，你会看到字符串“T1”和“Main”的交替输出，
  这就是程序中有两条不同的执行路径在交叉执行，这就是直观概念上的
  线程，概念性的东西，理解就好，没有必要咬文嚼字的去背文字的定义。
   */
}
