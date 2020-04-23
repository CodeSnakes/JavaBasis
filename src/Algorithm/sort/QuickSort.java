package Algorithm.sort;

import java.util.Arrays;

/**
 * @author yichangkong
 * @create 2020-04-23-16:58 ͨ��һ������Ҫ��������ݷָ�ɶ����������֣� ����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
 *     Ȼ���ٰ��˷����������������ݷֱ���п������� ����������̿��Եݹ���У��Դ˴ﵽ�������ݱ����������
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {-9, 78, 0, 23, -567, 70,5,7};
    quickSort(arr, 0, arr.length - 1);
    System.out.println("���������" + Arrays.toString(arr));
  }

  public static void quickSort(int[] arr, int left, int right) {
    int l = left;
    int r = right;
    int pivot = arr[(l + r) / 2]; // ����ֵ
    System.out.println(" ����Pivot:  "+pivot);
    int temp = 0; // ��Ϊһ����ʱ����
    while (l < r) {
        //  �� pivot �����һֱ��,�ҵ����ڵ��� pivot ֵ,���˳�
        while (arr[l] < pivot) {
          l += 1;
        }
        // �� pivot ���ұ�һֱ��,�ҵ�С�ڵ��� pivot ֵ,���˳�
        while (arr[r] > pivot) {
          r -= 1;
        }
        if (l >= r) { // ���û�е� ����Σ���
          break;
        }
        // ���ߵ�ֵ index �Ѿ��ҵ� ��ʼת��
        temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;

          //���������󣬷������ arr[l] == pivot ֵ ��� r--�� ǰ��
          if(arr[l] == pivot) {
              r -= 1;
          }
         //���������󣬷������ arr[r] == pivot ֵ ��� l++�� ����
          if(arr[r] == pivot) {
              l += 1;
          }
    }
      // ��� l == r, ���� l++, r--, ����Ϊ����ջ���
      if (l == r) {
          l += 1;
          r -= 1;
      }
      //�������ѭ���ݹ�
      //����ݹ�
      if(left < r) {
          quickSort(arr, left, r);
      }
      //���ҵݹ�
      if(right > l) {
          quickSort(arr, l, right);
      }

  }
}