package Algorithm.sort;

import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-24-12:07
 * �鲢����MERGE-SORT�������ù鲢��˼��ʵ�ֵ����򷽷���
 * ���㷨���þ���ķ��Σ�divide-and-conquer��
 * ���ԣ����η��������(divide)��һЩС������Ȼ��ݹ���⣬
 * ����(conquer)�Ľ׶��򽫷ֵĽ׶εõ��ĸ���"�� ��"��һ�𣬼��ֶ���֮)��
 */
public class MergeSort {

  public static void main(String[] args) {

    int[] arr = {9,8,7,6,5,4,3,2,1};
    int[] temp=new int[arr.length];

    mergeSort(arr,0,arr.length-1,temp);

  }

  static public void mergeSort(int[] arr,int left,int right,int[] temp){

    if(left < right) {//right �� left ����mid�ı������𽥿���
      int mid = (left + right) / 2; //�м�����
      mergeSort(arr, left, mid, temp);//����ݹ���зֽ�
      mergeSort(arr, mid + 1, right, temp);//���ҵݹ���зֽ�
      merge(arr, left, mid, right, temp);//�ϲ�
      System.out.println(Arrays.toString(arr));
    }

  }


  /**
   * �ϲ��ķ���
   * @param arr �����ԭʼ����
   * @param left ����������еĳ�ʼ����
   * @param mid �м�����
   * @param right �ұ�����
   * @param temp ����ת������
   */
  static void merge(int[] arr,int left, int mid, int right, int[] temp) {

    System.out.println("Merge: r > " +right +"  l > "+left );
    int l = left; // ��ʼ�� i, ����������еĳ�ʼ����
    int r = mid + 1; //��ʼ�� j, �ұ��������еĳ�ʼ����
    int t = 0; // ָ�� temp ����ĵ�ǰ����

    // (һ)
    // �Ȱ���������(����)�����ݰ��չ�����䵽 temp ����
    // ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
    while (l <= mid && r <= right) {
      // ����
      // �����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
      // ������ߵĵ�ǰԪ�أ���䵽 temp ����
      // Ȼ�� t++, i++
      if (arr[l] <= arr[r]) {
        temp[t] = arr[l];
        t += 1;
        l += 1;
      } else { // ��֮,���ұ��������еĵ�ǰԪ�أ���䵽 temp ����
        temp[t] = arr[r];
        t += 1;
        r += 1;
      }

    }

    //(��)
    //����ʣ�����ݵ�һ�ߵ���������ȫ����䵽 temp
    while( l <= mid) { //��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽 temp
      temp[t] = arr[l];
      t += 1;
      l += 1;
    }
    while( r <= right) { //�ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽 temp
      temp[t] = arr[r];
      t += 1;
      r += 1;
    }
  //(��)
  //�� temp �����Ԫ�ؿ����� arr
  //ע�⣬������ÿ�ζ���������
    t = 0;
    int tempLeft = left; //
    while(tempLeft <= right) {
      arr[tempLeft] = temp[t];
      t += 1;
      tempLeft += 1;
    }

  }
}
