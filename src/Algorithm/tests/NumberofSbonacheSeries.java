package Algorithm.tests;

/**
 * @author yichangkong
 * @create 2020-04-28-15:59
 */
public class NumberofSbonacheSeries {

  public static void main(String[] args) {
    System.out.println(ladder(11));
  }
  public static int ladder(int n){//����

    if (n == 1) {
      return 1;
      }else if (n==2){
        return 2;
    }else {
        return ladder(n-1)+ladder(n-2);
    }
  }
//    ���ӣ�https://www.nowcoder.com/questionTerminal/db34a72925124e2b8483154a4934a19b
//    ��Դ��ţ����
//
//    ����Ҫ��11¥��ʱ���㵹��ȥһ��ֻ�ܴ��ڵ�10¥���ߵ�9¥�����仰˵���ǵ����9¥�ķ����������ϵ�10¥�ķ���������
//    �������ڵ�10¥���͵ô��ڵ�9¥���ߵ�8¥
//    �������ڵ�9¥���͵ô��ڵ�8¥���ߵ�7¥
//......
//    �������ڵ�3¥���͵ô��ڵ�1¥���ߵ�2¥
//    ��1¥һ�ַ�����
//    ��2¥���ַ�����
//    ��3¥������1¥����������2¥�ķ���������
//    ����ѧ�����ǣ�
//    a��11��=a��10��+a��9��=144
//    a��10��=a��9��+a��8��=89
//    a��9��=a��8��+a��7��=55
//    a��8��=a��7��+a��6��=34
//    a��7��=a��6��+a��5��=21
//    a��6��=a��5��+a��4��=13
//    a��5��=a��4��+a��3��=8
//    a��4��=a��3��+a��2��=5
//    a��3��=a��2��+a��1��=3
//    a��2��=2
//    a��1��=1
}
