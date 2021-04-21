package Algorithm.sort;

import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-16-16:09 选择排序（select sorting）也是一种简单的排序方法。 它的基本思想是：
 *     第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换， 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 *     第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…， 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 *     第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换， 总共通过n-1次，得到一个按排序码从小到大排列的有序序列
 *     插入排序
 */
public class SelectSort选择排序 {

  public static void main(String[] args) {

    int[] arr = {101, 34, 119, 1};

     System.out.println("before： "+ Arrays.toString(arr));

      sort(arr);

      System.out.println("after:  "+ Arrays.toString(arr));
  }

 public static void  sort(int[] arr){
      int tamp;//中间变量
      for (int i = 0; i < arr.length-1; i++) {

          int min = arr[i]; // 假设目前循环的最小值
          int flag = i; // 记录最小值的下标

          for (int j = i; j < arr.length; j++) {
              if (min > arr[j]) {
                  min = arr[j];
                  flag = j;
              }
          }
          // 第一遍循环结束 将最小值进行更换
          if(i!=flag){//如果flag已经改变
              tamp=arr[i];
              arr[i]=arr[flag];
              arr[flag]=tamp;
          }
        //System.out.println("第"+i+"次:    "+ Arrays.toString(arr));
      }
  }
}
