package Other;

import java.util.Scanner;
/**
 * @author yichangkong
 * @create 2020-06-23-10:16
 */
public class dewenwen {
  public static void func() {
    System.out.print("请输入您要判断的年份:");
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    System.out.print("请输入你要判断的月份为:");
    int m = sc.nextInt();
    int d = 0;
    switch (m) {
      case 1:
        d = 31;
        break;
      case 2:
        d = 28;
        break;
      case 3:
        d = 31;
        break;
      case 4:
        d = 30;
        break;
      case 5:
        d = 31;
        break;
      case 6:
        d = 30;
        break;
      case 7:
        d = 31;
        break;
      case 8:
        d = 31;
        break;
      case 9:
        d = 30;
        break;
      case 10:
        d = 31; // 加break 不加break就不会bai跳出switch结构，
        // 不管后面条件是case 否符合都会执行，zhi直到遇到第一个break才会跳出switch结构dao

      case 12:
        d = 1;
        break;
      default:
        System.out.println("对不起，您输入的月份有误！");
        break;
    }
    if ((y%4==0&&y%100!=0)||y%400==0) { // (y%4==0&&y%100!=0)||y%400==0y % 400 == 0 || y % 4 == 0 || y % 100 != 0
      // 2019
      System.out.println("2019%400=" + 2019 % 400);
      System.out.println("2019%4=" + 2019 % 4);
      System.out.println("2019%100=" + 2019 % 100);
      /**
       * 闰年的判断规则如下：
       *
       * <p>1.若某个年份能被du4整除但不能被100整除，则是闰年。
       *
       * <p>2.若某个年份能被400整除，则也是闰年。
       *
       * <p>&&的运算规则：
       *
       * <p>i.当符号左边表达式为false时，&&将直接返回false不在判断符号右边表达式的结果。
       *
       * <p>ii.当符号左边表达式为true时，将继续判断符号右边表达式，||的结果与右边表达式结果一致。
       *
       * <p>||的运算规则：
       *
       * <p>i.当符号左边表达式为true时，||将直接返回true不在判断符号右边的表达式结果。
       *
       * <p>ii.当符号左边表达式为false时，将继续判断符号右边表达式，&&的结果与右边表达式结果一致。
       */
      System.out.println(y + "是闰年.");
      if (m == 2) ++d;
      System.out.println("您输入该月份的天数为：" + d);
    } else {
      System.out.println(y + "不是闰年");
      System.out.println("您输入该月份的天数为：" + d);
    }
  }
}
