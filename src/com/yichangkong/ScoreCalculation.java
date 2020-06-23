package com.yichangkong;

import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-06-22-14:19 任务八：
 * 评分计算功能。 计算并输出一维数组中的最大值、最小值和平均值。 （如： 9.8 , 12 , 45 , 67 , 23 , 1.98 ,
 *     2.55 , 45 ） 。
 */
public class ScoreCalculation {
  public static void func() {
//            Scanner sc = new Scanner(System.in);
//            int n=sc.nextInt();
    double[] d = new double[]{9.8, 12, 45, 67, 23, 1.98, 2.55, 45};
    /**
     * 第一种方法：
     * int [] arr = new int [6];
     * int intValue = arr [5];
     * 第二种方法： int [] x = {1,2,3,4};
     * 第三种方法：
     * int [] y = new int [] {1,2,3,4,5};
     */
    double max = 0; // 当前最大值
    double min = 0; // 当前最小值
//     for(int i=0;i<n;i++) //将其改为 for(int i=0;i<n;i++)
//      d[i]=sc.nextDouble();

     double sum = 0;
    for (int i = 0; i < d.length; i++) {

       sum += d[i];

      if (i == 0) // 假设第一个最大,最小
      max = min = d[0];
      if (d[i] > max) // 大于最大
      max = d[i];
      if (d[i] < min) // 小于最小
      min = d[i];
    }
    System.out.println("最大值:" + max);
    System.out.println("最小值:" + min);
    System.out.println("平均值：" + sum / d.length);
  }
}
