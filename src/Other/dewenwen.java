package Other;

import java.util.Scanner;
/**
 * @author yichangkong
 * @create 2020-06-23-10:16
 */
public class dewenwen {
  public static void func() {
    System.out.print("��������Ҫ�жϵ����:");
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    System.out.print("��������Ҫ�жϵ��·�Ϊ:");
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
        d = 31; // ��break ����break�Ͳ���bai����switch�ṹ��
        // ���ܺ���������case ����϶���ִ�У�zhiֱ��������һ��break�Ż�����switch�ṹdao

      case 12:
        d = 1;
        break;
      default:
        System.out.println("�Բ�����������·�����");
        break;
    }
    if ((y%4==0&&y%100!=0)||y%400==0) { // (y%4==0&&y%100!=0)||y%400==0y % 400 == 0 || y % 4 == 0 || y % 100 != 0
      // 2019
      System.out.println("2019%400=" + 2019 % 400);
      System.out.println("2019%4=" + 2019 % 4);
      System.out.println("2019%100=" + 2019 % 100);
      /**
       * ������жϹ������£�
       *
       * <p>1.��ĳ������ܱ�du4���������ܱ�100�������������ꡣ
       *
       * <p>2.��ĳ������ܱ�400��������Ҳ�����ꡣ
       *
       * <p>&&���������
       *
       * <p>i.��������߱��ʽΪfalseʱ��&&��ֱ�ӷ���false�����жϷ����ұ߱��ʽ�Ľ����
       *
       * <p>ii.��������߱��ʽΪtrueʱ���������жϷ����ұ߱��ʽ��||�Ľ�����ұ߱��ʽ���һ�¡�
       *
       * <p>||���������
       *
       * <p>i.��������߱��ʽΪtrueʱ��||��ֱ�ӷ���true�����жϷ����ұߵı��ʽ�����
       *
       * <p>ii.��������߱��ʽΪfalseʱ���������жϷ����ұ߱��ʽ��&&�Ľ�����ұ߱��ʽ���һ�¡�
       */
      System.out.println(y + "������.");
      if (m == 2) ++d;
      System.out.println("��������·ݵ�����Ϊ��" + d);
    } else {
      System.out.println(y + "��������");
      System.out.println("��������·ݵ�����Ϊ��" + d);
    }
  }
}
