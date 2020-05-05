package Algorithm.tests;

/**
 * 牛国在导弹阵地部署导弹系统，根据上级指示精神，这个导弹阵地每天希望发射至少M粒导弹到敌国阵地，
 * 但是因为牛国科技问题，一个导弹系统每天只可以发射一粒导弹，并且当连续发射A天时，机器就会过热导致系统需要冷却B天才可以继续使用。
 * 同时我们知道导弹系统在交接的时候，至少需要有一个导弹系统是可以工作的，不然敌国会乘机攻击我们。 也就是说除了第一天部署导弹系统的时候，我们在部署导弹前要保证有一个导弹系统是可以使用的。
 * 作为牛国的军事官，你该如何决策每天的导弹系统部署，期望以最少的导弹系统满足这个上级的指示要求。
 * @author yichangkong
 * @create 2020-05-05-12:23
 */
public class LeastDeployedMissile {
  public static void main(String[] args) {
    System.out.println(solve(4, 3, 2));
  }

  /**
   * @param A int整型 可以连续发射A天
   * @param B int整型 需要连续冷却B天
   * @param M int整型 每天至少需要发射M粒导弹
   * @return int整型
   */
  public static int solve(int A, int B, int M) {
    //我的代码通过率为30%
    // write code here
    int max = M;
    if ((B + 1) <= A) {
      max += M;
    } else {
      max += 1+ M * (B + 1) / A; // 因为修复时间大于一次发射的持久性 这里便于空档期
    }
    return max;
  }
  public static int solve1(int A, int B, int M) {
    int sum = M;
    sum += M * ((B + 1) / A);
    // SUM = M + M*((B+1)/A)
    // 单日发射值乘以 修复日
    if ((B + 1) % A != 0) {
      sum += M;
    }
    return sum;
  }
}
