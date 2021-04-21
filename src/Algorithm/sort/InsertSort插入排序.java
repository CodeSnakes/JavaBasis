package Algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yichangkong
 * @create 2020-04-16-17:41
 * 插入排序 这个算法很妙！！!
 */
public class InsertSort插入排序 {
    public static void main(String[] args) {

        int[] arr= {101, 34, 119, 1};

        insertSorts(arr);

    System.out.println(Arrays.toString(arr));
    }


    static public void insertSorts(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int indexVal = arr[i]; // 34
            int index = i - 1;
            while (index >= 0 && indexVal < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = indexVal;
        }
    }
}
