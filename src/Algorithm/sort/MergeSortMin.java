package Algorithm.sort;
import java.util.Arrays;
/**
 *
 * @author yichangkong
 * @create 2020-04-24-19:20
 */
public class MergeSortMin {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }
    static public void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
            System.out.println(Arrays.toString(arr));
        }
    }
    static void merge(int[] arr,int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t += 1;
                l += 1;
            } else {
                temp[t] = arr[r];
                t += 1;
                r += 1;
            }
        }
        while( l <= mid) {
            temp[t] = arr[l];
            t += 1;
            l += 1;
        }
        while( r <= right) {
            temp[t] = arr[r];
            t += 1;
            r += 1;
        }
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
