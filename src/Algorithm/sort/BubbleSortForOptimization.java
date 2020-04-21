package Algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @author yichangkong
 * @create 2020-04-14-18:15
 * ð�������Ż���
 *
 */
public class BubbleSortForOptimization {
    public static void main(String[] args) {

        int[] arrys = new int[800000];

        for(int i = 0; i < arrys.length; i++) {

            arrys[i]=(int) (Math.random()*80000000);

        }
        SelectSort selectSort = new SelectSort();
        Date date = new Date();
        System.out.println("����ǰ�� Arrays.toString(arrys)"+"ʱ�䣺 "+date);

        //InsertSort.insertSorts(arrys);
        //selectSort.sort(arrys);
        //bubbleSort(arrys);
        Date date1 = new Date();
        System.out.println("����ǰ�� Arrays.toString(arrys)"+"ʱ�䣺 "+date1);
        System.out.println("����ʱ��    "+(date1.getTime()-date.getTime())/1000+"S");

    }
  /**
   * @Description���һ�˱Ƚ��� ��û�н��й���������˵�������������Ҫ���������������
   * һ����־flag�ж�Ԫ���Ƿ���й��������Ӷ����ٲ���Ҫ�ıȽϡ�
   * @Param [arrys] @Return void @Date 2020/4/14 @Time 18:21
   */
  public static void bubbleSort(int[] arrys) {

        boolean flag=false;//�������ݱ�ʶ

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
            if(!flag){//˵���ôα������鲢û���н���
                return;
            }else{
                flag=false;//���Ƚϴ�Сʱ���ĵ�flagֵ��������
            }
        }


    }
}
