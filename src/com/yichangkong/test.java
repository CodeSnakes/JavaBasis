package com.yichangkong;

import java.util.Scanner;

/**
 * @author yichangkong
 * @create 2020-06-24-10:23
 */
public class test {
  public static void func() {
    System.out.println("��������:");
    int n;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    if (n > 100 || n < 0) {
      System.out.println("error");
    } else {
      String string = (n > 90) ? "�֣�A��" : ((n > 60) ? "�֣�B��" : "�֣�c��");
      System.out.println(n + string);
    }
  }
}
