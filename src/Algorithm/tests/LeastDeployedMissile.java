package Algorithm.tests;

/**
 * ţ���ڵ�����ز��𵼵�ϵͳ�������ϼ�ָʾ��������������ÿ��ϣ����������M���������й���أ�
 * ������Ϊţ���Ƽ����⣬һ������ϵͳÿ��ֻ���Է���һ�����������ҵ���������A��ʱ�������ͻ���ȵ���ϵͳ��Ҫ��ȴB��ſ��Լ���ʹ�á�
 * ͬʱ����֪������ϵͳ�ڽ��ӵ�ʱ��������Ҫ��һ������ϵͳ�ǿ��Թ����ģ���Ȼ�й���˻��������ǡ� Ҳ����˵���˵�һ�첿�𵼵�ϵͳ��ʱ�������ڲ��𵼵�ǰҪ��֤��һ������ϵͳ�ǿ���ʹ�õġ�
 * ��Ϊţ���ľ��¹٣������ξ���ÿ��ĵ���ϵͳ�������������ٵĵ���ϵͳ��������ϼ���ָʾҪ��
 * @author yichangkong
 * @create 2020-05-05-12:23
 */
public class LeastDeployedMissile {
  public static void main(String[] args) {
    System.out.println(solve(4, 3, 2));
  }

  /**
   * @param A int���� ������������A��
   * @param B int���� ��Ҫ������ȴB��
   * @param M int���� ÿ��������Ҫ����M������
   * @return int����
   */
  public static int solve(int A, int B, int M) {
    //�ҵĴ���ͨ����Ϊ30%
    // write code here
    int max = M;
    if ((B + 1) <= A) {
      max += M;
    } else {
      max += 1+ M * (B + 1) / A; // ��Ϊ�޸�ʱ�����һ�η���ĳ־��� ������ڿյ���
    }
    return max;
  }
  public static int solve1(int A, int B, int M) {
    int sum = M;
    sum += M * ((B + 1) / A);
    // SUM = M + M*((B+1)/A)
    // ���շ���ֵ���� �޸���
    if ((B + 1) % A != 0) {
      sum += M;
    }
    return sum;
  }
}
