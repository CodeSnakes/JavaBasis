package Algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-14-17:02
 * Bubble Sorting ð��������Ż��� ��ΪһЩ�������� ����ȫ������������ �����������������˳��ͳһ
 */
public class BubbleSorting {

  public static void main(String[] args) {

    int[] arr = new int[]{3, 9, -1, 10, -2} ;
//  int[] arr = {3, 9, -1, 10, -2}
//    ��һ��������ǽ�������ֵ�������
    for (int j=1; j < arr.length; j++) {
      int a;
      for (int i = 0; i < arr.length - j; i++) {
        if (arr[i] > arr[i + 1]) {
          a = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = a;
        }
      }
      System.out.println("��"+j+"������");
      System.out.println(Arrays.toString(arr));
    }
  }
}
