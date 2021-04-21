package Algorithm.search;

import java.util.Arrays;
/**
 * LeastDeployedMissile
 * 玄学斐波那契
 * @author yichangkong
 * @create 2020-05-04-20:58
 */
public class FibonacciSearch斐波那契查找 {
  public static int maxSize = 20;

  public static void main(String[] args) {

    int[] arr = {1, 8, 10, 89, 1000, 1234};

    fibSearch(arr,1234);
  }
  /**
   * @Description 因为后面我们 mid=low+F(k-1)-1，需要使用到斐波那契数列， 因此我们需要先获取到一个斐波那契数列
   * 非递归方法得到一个斐波那契数列 @Param[] @Return void @Date 2020/5/4 @Time 21:11
   */
  public static int[] fibonacci() {

    int[] fib = new int[maxSize];
    fib[0] = 1;
    fib[1] = 1;
    for (int i = 2; i < maxSize; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    return fib;
  }
  /**
   * @Description 编写斐波那契查找算法 使用非递归的方式编写算法
   *
   * @param a 数组
   * @param key 我们需要查找的关键码(值)
   * @return 返回对应的下标，如果没有-1
   */
  public static int fibSearch(int[] a, int key) {
    int low = 0;
    int high = a.length - 1;
    int k = 0; // 表示斐波那契分割数值的下标
    int mid = 0; // 存放 mid 值
    int f[] = fibonacci(); // 获取到斐波那契数列

    while (high > f[k] - 1) { // 获取到斐波那契分割数值的下标 也就是 1 1 2 3 5 8 这些对应的数组个数 这个案例需要数组为8
      k++;
    }
    // 因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用 Arrays 类，构造一个新的数组，并指向 temp[]
    // 不足的部分会使用 0 填充
    int[] temp = Arrays.copyOf(a, f[k]);
    // 实际上需求使用 a 数组最后的数填充 temp
    // temp = {1,8, 10, 89, 1000, 1234, 0, 0} => {1,8, 10, 89, 1000, 1234, 1234} 8个
    for (int i = high + 1; i < temp.length; i++) {
      temp[i] = a[high];
    }

    // 使用 while 来循环处理，找到我们的数 key
    while (low <= high) { // 只要这个条件满足，就可以找

      mid = low + f[k - 1] - 1;

      if (key < temp[mid]) { // 我们应该继续向数组的前面查找(左边)
        high = mid - 1;

        /*说明为甚是 k--
        1. 全部元素 = 前面的元素 + 后边元素
        2. f[k] = f[k-1] + f[k-2]
        因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
        即 在 f[k-1] 的前面继续查找 k--
        即下次循环 mid = f[k-1-1]-1*/
        k--;
      } else if (key > temp[mid]) { // 我们应该继续向数组的后面查找(右边)
        low = mid + 1;

        /*说明为什么是 k -=2
        1. 全部元素 = 前面的元素 + 后边元素
        2. f[k] = f[k-1] + f[k-2]
        f[k]转换成f[k-2]  f[k-1] 变成 low
        3. 因为后面我们有 f[k-2] 所以可以继续拆分 f[k-2] = f[k-3] + f[k-4]
        4. 即在 f[k-2] 的前面进行查找 k -=2
        5. 即下次循环 mid = f[k - 1 - 2] - 1*/
        k -= 2;
      } else {
        // 找到 需要确定，返回的是哪个下标
        if (mid <= high) {
          return mid;
        } else {
          return high;
        }
      }
    }
    return -1; // 如果没有找到
  }
}
