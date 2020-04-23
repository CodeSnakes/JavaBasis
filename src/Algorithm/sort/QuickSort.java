package Algorithm.sort;

import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-23-16:58 通过一趟排序将要排序的数据分割成独立的两部分， 其中一部分的所有数据都比另外一部分的所有数据都要小，
 *     然后再按此方法对这两部分数据分别进行快速排序， 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {-9, 78, 0, 23, -567, 70,5,7};
    quickSort(arr, 0, arr.length - 1);
    System.out.println("快速排序后：" + Arrays.toString(arr));
  }

  public static void quickSort(int[] arr, int left, int right) {
    int l = left;
    int r = right;
    int pivot = arr[(l + r) / 2]; // 中轴值
    System.out.println(" 本次Pivot:  "+pivot);
    int temp = 0; // 作为一个临时变量
    while (l < r) {
        //  在 pivot 的左边一直找,找到大于等于 pivot 值,才退出
        while (arr[l] < pivot) {
          l += 1;
        }
        // 在 pivot 的右边一直找,找到小于等于 pivot 值,才退出
        while (arr[r] > pivot) {
          r -= 1;
        }
        if (l >= r) { // 如果没有到 该如何？？
          break;
        }
        // 两边的值 index 已经找到 开始转换
        temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;

          //如果交换完后，发现这个 arr[l] == pivot 值 相等 r--， 前移
          if(arr[l] == pivot) {
              r -= 1;
          }
         //如果交换完后，发现这个 arr[r] == pivot 值 相等 l++， 后移
          if(arr[r] == pivot) {
              l += 1;
          }
    }
      // 如果 l == r, 必须 l++, r--, 否则为出现栈溢出
      if (l == r) {
          l += 1;
          r -= 1;
      }
      //后面进行循环递归
      //向左递归
      if(left < r) {
          quickSort(arr, left, r);
      }
      //向右递归
      if(right > l) {
          quickSort(arr, l, right);
      }

  }
}