package Algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yichangkong
 * @create 2020-05-03-15:59
 */
public class DichotomySearchPro {
    public static void main(String[] args) {
        //int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,10, 10,11, 12, 13,14,15,16,17,18,19,20 };
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 10);
        System.out.println("resIndexList=" + resIndexList);
    }
  /*�κ�˼����:
   * �κ�˼���⣺ {1,8, 10, 89, 1000, 1000��1234} ��һ�����������У�
   * �ж����ͬ����ֵʱ����ν����е���ֵ�����ҵ������������ 1000
   * ˼·����
   * 1. ���ҵ�mid ����ֵ����Ҫ���Ϸ���
   * 2. ��mid ����ֵ�����ɨ�裬���������� 1000�� ��Ԫ�ص��±꣬���뵽����ArrayList
   * 3. ��mid ����ֵ���ұ�ɨ�裬���������� 1000�� ��Ԫ�ص��±꣬���뵽����ArrayList
   * 4. ��Arraylist����
   * tips����Ϊ���ҵ�����ǰ���������  ���Ե����Ǳ�����С�ڻ��ߴ��ڵĲ���ֵ ������ֹͣ����ѭ��
   */

  /**���ֲ����㷨
   * @param arr ����
   * @param left ��ߵ�����
   * @param right �ұߵ�����
   * @param findVal  Ҫ���ҵ�ֵ
   * @return ����ҵ��ͷ����±꣬���û���ҵ����ͷ��� ArrayList<Integer>
   */
  public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

    System.out.println("hello~");
    // �� left > right ʱ��˵���ݹ��������飬����û���ҵ�
    if (left > right) {
      return new ArrayList<Integer>();
    }
    int mid = (left + right) / 2;
    int midVal = arr[mid];
    if (findVal > midVal) { // ���ҵݹ�
      return binarySearch2(arr, mid + 1, right, findVal);
    } else if (findVal < midVal) { // ����ݹ�
      return binarySearch2(arr, left, mid - 1, findVal);
    } else {
      List<Integer> resIndexlist = new ArrayList<Integer>();
      // ��mid ����ֵ�����ɨ�裬���������� 1000�� ��Ԫ�ص��±꣬���뵽����ArrayList
      int temp = mid - 1;
      boolean flag1= true;//�����˳�����
      while (flag1) {
        if (temp < 0 || arr[temp]<findVal) { //�˳�
          flag1=false;
          break;
        }
        if (arr[temp]==findVal){
          resIndexlist.add(temp); // ���򣬾�temp ���뵽 resIndexlist
        }
        temp -= 1; // temp����
      }
      resIndexlist.add(mid);
      temp = mid + 1;// ��mid ����ֵ���ұ�ɨ�裬���������� 1000�� ��Ԫ�ص��±꣬���뵽����ArrayList

      boolean flag2=true;
      while (flag2) {
        if (temp > arr.length - 1 || arr[temp]>findVal) { // �˳�
          flag2=false;
          break;
        }
        if (arr[temp]==findVal){
          resIndexlist.add(temp); // ���򣬾�temp ���뵽 resIndexlist
        }
        temp += 1; // temp����
      }
      return resIndexlist;
    }
  }
}
