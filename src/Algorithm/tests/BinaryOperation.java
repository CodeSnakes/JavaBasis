package Algorithm.tests;

/**
 * binaryOperation
 * @author yichangkong
 * @create 2020-04-29-17:30
 *     <p>��Ϊ65530��Ӧ�Ķ�����Ϊ��1111 1111 1111 1010 ��x=x&(x-1)�������ǲ��ϵ���xС1��������������
 *     ʵ�����������Ǽ���һ�����ж����Ƶ�1�ĸ��� ���磺
 *     1111 1111 1111 1010 & 1111 1111 1111 1001 = 1111 1111 1111 1000 1111 1111 1111 1000 & 1111
 *     1111 1111 0111 = 1111 1111 1111 0000
 *     . . .
 *     ��������65530��Ӧ�Ķ���������14��1,���Դ�Ϊ14��ѡB
 */
public class BinaryOperation {
  public static void main(String[] args) {
    System.out.println(func(65530));//=14
  }
  static public   int func(int x)
    {
        int countx = 0;
        while (x!=0)
        {
            countx++;
            x = x & (x - 1);
        }
        return countx;
    }
}
