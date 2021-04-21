package Algorithm.sort;

import sun.security.util.Length;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-22-17:42 希尔排序 太强 第三层for循环我硬是有些不明白！！！！
 *     <p>希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 *     随着增量逐渐减少，每组包含的关键词越来越多 当增量减至1时，
 *     整个文件恰被分成一组，算法便终止
 *
 *     <p>希尔排序时， 对有序序列在插入时采用交换法, 并测试排序速度.
 *     <p>希尔排序时， 对有序序列在插入时采用移动法, 并测试排序速度
 */
public class ShellSort希尔排序 {
  public static void main(String[] args) {

    int[] arr = {8,9,1,7,2,3,5,4,6,0};
    System.out.println(Arrays.toString(arr));
    shells2(arr);
    System.out.println(Arrays.toString(arr));

  }
  //采用移动法
    static public void shells2(int[] arr){

        for (int j = arr.length/2; j >0; j/=2){
            System.out.println("per： "+j);
            //从第 j 给元素开始 逐个对其所在的组进行直接插入排序
            for(int i = j; i <arr.length; i++) {
                int x=i;
                int temp=arr[x];
                if(arr[x]<arr[x-j]){
                    while (x-j>=0&&temp<arr[x-j]){
                        //移动
                        arr[x]=arr[x-j];
                        x-=j;
                    }
                    //当while退出循环的时候 就给temp找到插入的位置
                    arr[x]=temp;
                }
            }
        }
    }
//交换法
 static public void shells(int[] arr){
    int num=0;
    for (int j = 2; j <= (arr.length/2)+1; j+=2){
            int per =arr.length / j;
      System.out.println("per： "+per);
        for (int i = per; i < arr.length; i++) {
            int temp = 0;
            for(int k = i-per; k >=0 ; k-=per) {//k=（i-per）-per
                if(arr[k]>arr[k+per]){
                    temp=arr[k];
                    arr[k]=arr[k+per];
                    arr[k+per]=temp;
                }
            }
        }
        System.out.println("第"+(num++)+"次："+Arrays.toString(arr));
     }
    }
}

