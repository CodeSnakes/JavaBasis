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
  �۲������������ݽ������ῴ���ַ�����T1���͡�Main���Ľ��������
  ����ǳ�������������ͬ��ִ��·���ڽ���ִ�У������ֱ�۸����ϵ�
  �̣߳������ԵĶ��������ͺã�û�б�Ҫҧ�Ľ��ֵ�ȥ�����ֵĶ��塣
   */
}
