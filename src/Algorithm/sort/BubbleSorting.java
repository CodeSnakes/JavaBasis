package Algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-14-17:02
 * Bubble Sorting 冒泡排序非优化版 因为一些排序数组 不需全部遍历完排序 便可以完成整个数组的顺序统一
 */
public class BubbleSorting {

  public static void main(String[] args) {

    int[] arr = new int[]{3, 9, -1, 10, -2} ;
//  int[] arr = {3, 9, -1, 10, -2}
//    第一次排序就是将最大的数值排在最后
    for (int j=1; j < arr.length; j++) {
      int a;
      for (int i = 0; i < arr.length - j; i++) {
        if (arr[i] > arr[i + 1]) {
          a = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = a;
        }
      }
      System.out.println("第"+j+"次排序");
      System.out.println(Arrays.toString(arr));
    }
  }
}
