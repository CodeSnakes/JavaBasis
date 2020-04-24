package Algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yichangkong
 * @create 2020-04-24-21:43
 */
public class RadixSort {

  static   List<List> lists = new ArrayList<>();

  public static void main(String[] args) {

      int[] arr= {53, 3, 1,42,666 ,895,48,321, 14, 34,331,452};
      for (int i = 0; i < 10; i++){ //生成十个模拟装值的桶 list 存 list
          lists.add(i,new ArrayList());//int[] 不好定义数量 所以改换为list
      }
      radixSort(arr);
      System.out.println(Arrays.toString(arr));
  }
  static  public void radixSort(int[] arr){
      int index=0;//位数的指向
      boolean flag=true;//最外层的遍历是根据最大值的位数 所以我需要一个标注 来表示一次循环中是否有当前位数的值
      int temp=0;//用于放入桶的间接值
      if(flag){
          //(一)开始往桶里放值
          for (int i=1;i>0;i*=10){//遍历一次这意味着所求的位数则要改变
              int sum=0;//用于统计本次遍历是否有一个该位数的值
              for (int num : arr) {//取出每一个值进行取位数值
                  index = num/i%10;
                  if (index>0) sum++;
                  temp=num;
                  switchs(index,temp);  //取值操作完成 开始入桶
              }
            //（二）开始从桶取值
            int s =0;//数组的index
            for(int j = 0; j < 10; j++) {
                List list =lists.get(j);
                if (list.size()!=0){
                    for (int k = 0; k <list.size(); k++) {//
                        arr[s]=(Integer) lists.get(j).get(k);
                        s++;
                }
            }
             //（三）取值完成 清除
             list.clear();
        }
            //（四）退出本次循环
           if(sum==0){//退出排序算法
               flag=false;
           }
          }
      }
  }
  static public void switchs(int index,int temp){
      switch(index){
          case 0 :
              lists.get(0).add(temp);
              break;
          case   1:
              lists.get(1).add(temp);
              break;
          case   2:
              lists.get(2).add(temp);
              break;
          case   3:
              lists.get(3).add(temp);
              break;
          case   4:
              lists.get(4).add(temp);
              break;
          case   5:
              lists.get(5).add(temp);
              break;
          case   6:
              lists.get(6).add(temp);
              break;
          case   7:
              lists.get(7).add(temp);
              break;
          case   8:
              lists.get(8).add(temp);
              break;
          case   9:
              lists.get(9).add(temp);
              break;
          default :
              break;
      }
  }
}
