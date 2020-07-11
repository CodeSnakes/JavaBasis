package com.yichangkong;

import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-06-24-10:23
 */
public class test {
  public static void func() {
    System.out.println("输入整数:");
    int n;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    if (n > 100 || n < 0) {
      System.out.println("error");
    } else {
      String string = (n > 90) ? "分，A等" : ((n > 60) ? "分，B等" : "分：c等");
      System.out.println(n + string);
    }
  }
}
