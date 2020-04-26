package Algorithm.search;

/**
 * Dichotomy
 * @author yichangkong
 * @create 2020-04-26-14:32
 */
public class LinearSearch {
  public static void main(String[] args) {

    int[] arr = {1, 9, 11, -1, 34, 89}; // 没有顺序的数组
    int value = 8;
    int index = linearSearch(arr, value);
    if (index>=0){
      System.out.println(index);
    }else {
      System.out.println("Not Found");
    }
  }

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}