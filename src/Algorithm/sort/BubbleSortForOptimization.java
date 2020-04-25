package Algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @author yichangkong
 * @create 2020-04-14-18:15
 * 冒泡排序优化版
 *
 */
public class BubbleSortForOptimization {
    public static void main(String[] args) {

        int[] arrys = new int[8000000];

        for(int i = 0; i < arrys.length; i++) {

            arrys[i]=(int) (Math.random()*80000000);

        }
        SelectSort selectSort = new SelectSort();
        Date date = new Date();
        System.out.println("排序前： Arrays.toString(arrys)"+"时间： "+date);
       // System.out.println(Arrays.toString(arrys));

        //QuickSort.quickSort(arrys,0,arrys.length-1);

        //RadixSort.radixSort(arrys);
        RadixSortPro.radixSort(arrys);

        Date date1 = new Date();
        //System.out.println(Arrays.toString(arrys));
        System.out.println("排序前： Arrays.toString(arrys)"+"时间： "+date1);
        System.out.println("共用时：    "+(date1.getTime()-date.getTime())/1000+"S");


    }
  /**
   * @Description如果一趟比较下 来没有进行过交换，就说明序列有序，因此要在排序过程中设置
   * 一个标志flag判断元素是否进行过交换。从而减少不必要的比较。
   * @Param [arrys] @Return void @Date 2020/4/14 @Time 18:21
   */
  public static void bubbleSort(int[] arrys) {

        boolean flag=false;//进行数据标识

        for (int j=1; j < arrys.length; j++) {
            int a;
            for (int i = 0; i < arrys.length - j; i++) {
                if (arrys[i] > arrys[i + 1]) {
                    flag=true;
                    a = arrys[i];
                    arrys[i] = arrys[i + 1];
                    arrys[i + 1] = a;
                }
            }
            if(!flag){//说明该次遍历数组并没进行交换
                return;
            }else{
                flag=false;//将比较大小时更改的flag值进行重置
            }
        }


    }
}
