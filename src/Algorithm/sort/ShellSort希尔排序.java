package Algorithm.sort;

import sun.security.util.Length;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-22-17:42 ϣ������ ̫ǿ ������forѭ����Ӳ����Щ�����ף�������
 *     <p>ϣ�������ǰѼ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨����
 *     ���������𽥼��٣�ÿ������Ĺؼ���Խ��Խ�� ����������1ʱ��
 *     �����ļ�ǡ���ֳ�һ�飬�㷨����ֹ
 *
 *     <p>ϣ������ʱ�� �����������ڲ���ʱ���ý�����, �����������ٶ�.
 *     <p>ϣ������ʱ�� �����������ڲ���ʱ�����ƶ���, �����������ٶ�
 */
public class ShellSortϣ������ {
  public static void main(String[] args) {

    int[] arr = {8,9,1,7,2,3,5,4,6,0};
    System.out.println(Arrays.toString(arr));
    shells2(arr);
    System.out.println(Arrays.toString(arr));

  }
  //�����ƶ���
    static public void shells2(int[] arr){

        for (int j = arr.length/2; j >0; j/=2){
            System.out.println("per�� "+j);
            //�ӵ� j ��Ԫ�ؿ�ʼ ����������ڵ������ֱ�Ӳ�������
            for(int i = j; i <arr.length; i++) {
                int x=i;
                int temp=arr[x];
                if(arr[x]<arr[x-j]){
                    while (x-j>=0&&temp<arr[x-j]){
                        //�ƶ�
                        arr[x]=arr[x-j];
                        x-=j;
                    }
                    //��while�˳�ѭ����ʱ�� �͸�temp�ҵ������λ��
                    arr[x]=temp;
                }
            }
        }
    }
//������
 static public void shells(int[] arr){
    int num=0;
    for (int j = 2; j <= (arr.length/2)+1; j+=2){
            int per =arr.length / j;
      System.out.println("per�� "+per);
        for (int i = per; i < arr.length; i++) {
            int temp = 0;
            for(int k = i-per; k >=0 ; k-=per) {//k=��i-per��-per
                if(arr[k]>arr[k+per]){
                    temp=arr[k];
                    arr[k]=arr[k+per];
                    arr[k+per]=temp;
                }
            }
        }
        System.out.println("��"+(num++)+"�Σ�"+Arrays.toString(arr));
     }
    }
}

