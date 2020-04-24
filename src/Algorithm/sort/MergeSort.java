package Algorithm.sort;

import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-24-12:07
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）
 * 策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修 补"在一起，即分而治之)。
 */
public class MergeSort {

  public static void main(String[] args) {

    int[] arr = {9,8,7,6,5,4,3,2,1};
    int[] temp=new int[arr.length];

    mergeSort(arr,0,arr.length-1,temp);

  }

  static public void mergeSort(int[] arr,int left,int right,int[] temp){

    if(left < right) {//right 和 left 会在mid的遍历下逐渐靠近
      int mid = (left + right) / 2; //中间索引
      mergeSort(arr, left, mid, temp);//向左递归进行分解
      mergeSort(arr, mid + 1, right, temp);//向右递归进行分解
      merge(arr, left, mid, right, temp);//合并
      System.out.println(Arrays.toString(arr));
    }

  }


  /**
   * 合并的方法
   * @param arr 排序的原始数组
   * @param left 左边有序序列的初始索引
   * @param mid 中间索引
   * @param right 右边索引
   * @param temp 做中转的数组
   */
  static void merge(int[] arr,int left, int mid, int right, int[] temp) {

    System.out.println("Merge: r > " +right +"  l > "+left );
    int l = left; // 初始化 i, 左边有序序列的初始索引
    int r = mid + 1; //初始化 j, 右边有序序列的初始索引
    int t = 0; // 指向 temp 数组的当前索引

    // (一)
    // 先把左右两边(有序)的数据按照规则填充到 temp 数组
    // 直到左右两边的有序序列，有一边处理完毕为止
    while (l <= mid && r <= right) {
      // 继续
      // 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
      // 即将左边的当前元素，填充到 temp 数组
      // 然后 t++, i++
      if (arr[l] <= arr[r]) {
        temp[t] = arr[l];
        t += 1;
        l += 1;
      } else { // 反之,将右边有序序列的当前元素，填充到 temp 数组
        temp[t] = arr[r];
        t += 1;
        r += 1;
      }

    }

    //(二)
    //把有剩余数据的一边的数据依次全部填充到 temp
    while( l <= mid) { //左边的有序序列还有剩余的元素，就全部填充到 temp
      temp[t] = arr[l];
      t += 1;
      l += 1;
    }
    while( r <= right) { //右边的有序序列还有剩余的元素，就全部填充到 temp
      temp[t] = arr[r];
      t += 1;
      r += 1;
    }
  //(三)
  //将 temp 数组的元素拷贝到 arr
  //注意，并不是每次都拷贝所有
    t = 0;
    int tempLeft = left; //
    while(tempLeft <= right) {
      arr[tempLeft] = temp[t];
      t += 1;
      tempLeft += 1;
    }

  }
}
