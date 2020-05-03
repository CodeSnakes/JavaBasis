package Algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yichangkong
 * @create 2020-05-03-15:59
 */
public class DichotomySearchPro {
    public static void main(String[] args) {
        //int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,10, 10,11, 12, 13,14,15,16,17,18,19,20 };
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 10);
        System.out.println("resIndexList=" + resIndexList);
    }
  /*课后思考题:
   * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
   * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
   * 思路分析
   * 1. 在找到mid 索引值，不要马上返回
   * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
   * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
   * 4. 将Arraylist返回
   * tips：因为查找的数组前提是有序的  所以当我们遍历到小于或者大于的查找值 则立即停止遍历循环
   */

  /**二分查找算法
   * @param arr 数组
   * @param left 左边的索引
   * @param right 右边的索引
   * @param findVal  要查找的值
   * @return 如果找到就返回下标，如果没有找到，就返回 ArrayList<Integer>
   */
  public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

    System.out.println("hello~");
    // 当 left > right 时，说明递归整个数组，但是没有找到
    if (left > right) {
      return new ArrayList<Integer>();
    }
    int mid = (left + right) / 2;
    int midVal = arr[mid];
    if (findVal > midVal) { // 向右递归
      return binarySearch2(arr, mid + 1, right, findVal);
    } else if (findVal < midVal) { // 向左递归
      return binarySearch2(arr, left, mid - 1, findVal);
    } else {
      List<Integer> resIndexlist = new ArrayList<Integer>();
      // 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
      int temp = mid - 1;
      boolean flag1= true;//用于退出遍历
      while (flag1) {
        if (temp < 0 || arr[temp]<findVal) { //退出
          flag1=false;
          break;
        }
        if (arr[temp]==findVal){
          resIndexlist.add(temp); // 否则，就temp 放入到 resIndexlist
        }
        temp -= 1; // temp左移
      }
      resIndexlist.add(mid);
      temp = mid + 1;// 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList

      boolean flag2=true;
      while (flag2) {
        if (temp > arr.length - 1 || arr[temp]>findVal) { // 退出
          flag2=false;
          break;
        }
        if (arr[temp]==findVal){
          resIndexlist.add(temp); // 否则，就temp 放入到 resIndexlist
        }
        temp += 1; // temp右移
      }
      return resIndexlist;
    }
  }
}
