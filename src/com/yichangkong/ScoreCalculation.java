package com.yichangkong;

import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-06-22-14:19 ����ˣ�
 * ���ּ��㹦�ܡ� ���㲢���һά�����е����ֵ����Сֵ��ƽ��ֵ�� ���磺 9.8 , 12 , 45 , 67 , 23 , 1.98 ,
 *     2.55 , 45 �� ��
 */
public class ScoreCalculation {
  public static void func() {
//            Scanner sc = new Scanner(System.in);
//            int n=sc.nextInt();
    double[] d = new double[]{9.8, 12, 45, 67, 23, 1.98, 2.55, 45};
    /**
     * ��һ�ַ�����
     * int [] arr = new int [6];
     * int intValue = arr [5];
     * �ڶ��ַ����� int [] x = {1,2,3,4};
     * �����ַ�����
     * int [] y = new int [] {1,2,3,4,5};
     */
    double max = 0; // ��ǰ���ֵ
    double min = 0; // ��ǰ��Сֵ
//     for(int i=0;i<n;i++) //�����Ϊ for(int i=0;i<n;i++)
//      d[i]=sc.nextDouble();

     double sum = 0;
    for (int i = 0; i < d.length; i++) {

       sum += d[i];

      if (i == 0) // �����һ�����,��С
      max = min = d[0];
      if (d[i] > max) // �������
      max = d[i];
      if (d[i] < min) // С����С
      min = d[i];
    }
    System.out.println("���ֵ:" + max);
    System.out.println("��Сֵ:" + min);
    System.out.println("ƽ��ֵ��" + sum / d.length);
  }
}
