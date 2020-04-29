package Algorithm.tests;

/**
 * binaryOperation
 * @author yichangkong
 * @create 2020-04-29-17:30
 *     <p>因为65530对应的二进制为：1111 1111 1111 1010 而x=x&(x-1)的作用是不断的与x小1的数进行与运算
 *     实际它的作用是计算一个数中二进制的1的个数 例如：
 *     1111 1111 1111 1010 & 1111 1111 1111 1001 = 1111 1111 1111 1000 1111 1111 1111 1000 & 1111
 *     1111 1111 0111 = 1111 1111 1111 0000
 *     . . .
 *     所以最终65530对应的二进制中有14个1,所以答案为14，选B
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
