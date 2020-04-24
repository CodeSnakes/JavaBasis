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
      for (int i = 0; i < 10; i++){ //����ʮ��ģ��װֵ��Ͱ list �� list
          lists.add(i,new ArrayList());//int[] ���ö������� ���ԸĻ�Ϊlist
      }
      radixSort(arr);
      System.out.println(Arrays.toString(arr));
  }
  static  public void radixSort(int[] arr){
      int index=0;//λ����ָ��
      boolean flag=true;//�����ı����Ǹ������ֵ��λ�� ��������Ҫһ����ע ����ʾһ��ѭ�����Ƿ��е�ǰλ����ֵ
      int temp=0;//���ڷ���Ͱ�ļ��ֵ
      if(flag){
          //(һ)��ʼ��Ͱ���ֵ
          for (int i=1;i>0;i*=10){//����һ������ζ�������λ����Ҫ�ı�
              int sum=0;//����ͳ�Ʊ��α����Ƿ���һ����λ����ֵ
              for (int num : arr) {//ȡ��ÿһ��ֵ����ȡλ��ֵ
                  index = num/i%10;
                  if (index>0) sum++;
                  temp=num;
                  switchs(index,temp);  //ȡֵ������� ��ʼ��Ͱ
              }
            //��������ʼ��Ͱȡֵ
            int s =0;//�����index
            for(int j = 0; j < 10; j++) {
                List list =lists.get(j);
                if (list.size()!=0){
                    for (int k = 0; k <list.size(); k++) {//
                        arr[s]=(Integer) lists.get(j).get(k);
                        s++;
                }
            }
             //������ȡֵ��� ���
             list.clear();
        }
            //���ģ��˳�����ѭ��
           if(sum==0){//�˳������㷨
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
