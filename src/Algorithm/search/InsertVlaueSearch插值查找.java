package Algorithm.search;

/**
 * Fibonacci
 * ctrl shift f 格式化
 * 插值查找算法
 * 将折半查找中的求 mid 索引的公式 , low 表示左边索引 left, high 表示右边索引 right. key 就是前面我们讲的 findVal
 * int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]) ; 插值索引
 * 对应前面的代码公式：
 * int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])
 * @author yichangkong
 * @create 2020-05-04-15:23
 *
 * tips:还可以完善pro
 */
public class InsertVlaueSearch插值查找 {
  public static void main(String[] args) {

    int[] arr = new int[100];
    for (int i = 0; i < 100; i++) {
      arr[i] = i + 1;
    }
    System.out.println(insertValue(arr, 0, arr.length-1, 1));
  }

  public static int insertValue(int[] arr, int left, int right, int findVal) {
    System.out.println("test");

    if (left > right || arr[0] > findVal || arr[arr.length-1] < findVal) {
      return -1;
    }
    int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
    int midVal = arr[mid];
    if (midVal < findVal) { // 向右
      return insertValue(arr, mid + 1, right, findVal);
    } else if (midVal > findVal) { // 向左
      return insertValue(arr, left, mid - 1, findVal);
    } else {
      return mid;
    }
  }
}
