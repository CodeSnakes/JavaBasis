package Algorithm.sort;

import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-16-16:09 ѡ������select sorting��Ҳ��һ�ּ򵥵����򷽷��� ���Ļ���˼���ǣ�
 *     ��һ�δ�arr[0]~arr[n-1]��ѡȡ��Сֵ����arr[0]������ �ڶ��δ�arr[1]~arr[n-1]��ѡȡ��Сֵ����arr[1]������
 *     �����δ�arr[2]~arr[n-1]��ѡȡ��Сֵ����arr[2]���������� ��i�δ�arr[i-1]~arr[n-1]��ѡȡ��Сֵ����arr[i-1]��������,
 *     ��n-1�δ�arr[n-2]~arr[n-1]��ѡȡ��Сֵ����arr[n-2]������ �ܹ�ͨ��n-1�Σ��õ�һ�����������С�������е���������
 *     ��������
 */
public class SelectSortѡ������ {

  public static void main(String[] args) {

    int[] arr = {101, 34, 119, 1};

     System.out.println("before�� "+ Arrays.toString(arr));

      sort(arr);

      System.out.println("after:  "+ Arrays.toString(arr));
  }

 public static void  sort(int[] arr){
      int tamp;//�м����
      for (int i = 0; i < arr.length-1; i++) {

          int min = arr[i]; // ����Ŀǰѭ������Сֵ
          int flag = i; // ��¼��Сֵ���±�

          for (int j = i; j < arr.length; j++) {
              if (min > arr[j]) {
                  min = arr[j];
                  flag = j;
              }
          }
          // ��һ��ѭ������ ����Сֵ���и���
          if(i!=flag){//���flag�Ѿ��ı�
              tamp=arr[i];
              arr[i]=arr[flag];
              arr[flag]=tamp;
          }
        //System.out.println("��"+i+"��:    "+ Arrays.toString(arr));
      }
  }
}
