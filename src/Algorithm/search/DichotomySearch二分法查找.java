package Algorithm.search;

/**
 *
 * @author yichangkong
 * @create 2020-04-26-15:21
 */
public class DichotomySearch二分法查找 {

  public static void main(String[] args) {
      int[] arr={1,3,4,5,6};
      int index =dichotomy(0,arr.length-1,arr,7);
     System.out.println(index);
  }
//  这里一个大问题 mid++ 为何 mid+1 区别 i=0 k=i++;的执行逻辑是k=i; i=i+1

   static public int   dichotomy(int left,int right,int[] arr,int value){
       if (right<left){//说明本数组没有查询的值
           return -1;
       }
       int mid =(right+left)/2;
       int midVla=arr[mid];
      if(midVla<value){//向右递归
          return dichotomy(mid+1,right,arr,value);
       }else if (midVla>value){
          return dichotomy(left,mid-1,arr,value);
      }else {
          return mid;
      }
  }
}
