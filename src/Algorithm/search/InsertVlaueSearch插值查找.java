package Algorithm.search;

/**
 * Fibonacci
 * ctrl shift f ��ʽ��
 * ��ֵ�����㷨
 * ���۰�����е��� mid �����Ĺ�ʽ , low ��ʾ������� left, high ��ʾ�ұ����� right. key ����ǰ�����ǽ��� findVal
 * int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]) ; ��ֵ����
 * ��Ӧǰ��Ĵ��빫ʽ��
 * int mid = left + (right �C left) * (findVal �C arr[left]) / (arr[right] �C arr[left])
 * @author yichangkong
 * @create 2020-05-04-15:23
 *
 * tips:����������pro
 */
public class InsertVlaueSearch��ֵ���� {
  public static void main(String[] args) {

    int[] arr = new int[100];
    for (int i = 0; i < 100; i++) {
      arr[i] = i + 1;
    }
    System.out.println(insertValue(arr, 0, arr.length-1, 1));
  }

  public static int insertValue(int[] arr, int left, int right, int findVal) {
    System.out.println("test");

    if (left > right || arr[0] > findVal || arr[arr.length-1] < findVal) {
      return -1;
    }
    int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
    int midVal = arr[mid];
    if (midVal < findVal) { // ����
      return insertValue(arr, mid + 1, right, findVal);
    } else if (midVal > findVal) { // ����
      return insertValue(arr, left, mid - 1, findVal);
    } else {
      return mid;
    }
  }
}
