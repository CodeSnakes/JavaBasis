package com.yichangkong;

import java.util.concurrent.TimeUnit;

/**
 * @author yichangkong
 * @create 2020-06-16-23:54
 *
 * new Thread(()->{e.execute(inst,processVars);}).start();
 * Lambda������ί���߳�
 */
public class Sleep_Yield_Join {
  public static void main(String[] args) {
     //testSleep();
     testYield();
    //testJoin();
  }
  /*
  Sleep,��˼����˯�ߣ���ǰ�߳���ͣһ��ʱ���ø�����߳�ȥ���С�sleep����ô
  ����ģ������˯��ʱ���������˯�ߵ��涨��ʱ���Զ�����
   */
  static void testSleep() {

    new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println("A " + i);
                try {
                  Thread.sleep(500);
                  // TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            })
        .start();
  }
  /*Yield,���ǵ�ǰ�߳�����ִ�е�ʱ��ֹͣ��������ȴ����У�
  �ص��ȴ���������ϵͳ�ĵ����㷨��ͷ�ػ�����Ȼ�п��ܰ���ջ�ȥ������߳��û�������ִ�У�
  ��Ȼ������Ŀ������ǰ�ԭ���ȴ�����Щ�ó�һ����ִ�У�����yield����˼�����ó�һ��CPU��
  ���������ܲ����������Ҳ���*/

  static void testYield() {
    new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println("A " + i);
                if (i % 10 == 0) Thread.yield();
              }
            })
        .start();

    new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println("-----------B" + i);
                if (i % 10 == 0) Thread.yield();
              }
            })
        .start();
  }

  /*join�� ��˼�������Լ���ǰ�̼߳��������Join���̣߳�����
  ���̵߳ȴ����ȵ��õ��߳����� ���ˣ��Լ���ȥִ�С�
  t1��t2�����̣߳���t1��ĳ�����ϵ�����t2.join,�����ܵ�t2ȥ���У�
  t1�ȴ�t2�� ����ϼ���t1���У��Լ�join�Լ�û�����壩 */
  static void testJoin() {
    Thread t1 =
        new Thread(
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
              }
              try {
                Thread.sleep(500); // TimeUnit.Milliseconds.sleep(500)
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
    Thread t2 =
        new Thread(
            () -> {
              try {
                t1.join();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                  Thread.sleep(500); //
                }
                // TimeUnit.Milliseconds.sleep(500) }
                catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

      t1.start();
      t2.start();

  }
}
