package Concurrent.future;
import java.util.concurrent.RecursiveTask;

/**
 * @author yichangkong
 * @create 2020-08-08-23:06 factorial(阶乘)
 */
public class FactorialSquareCalculator extends RecursiveTask<Integer> {

  private static final long serialVersionUID = 1L;
  private final Integer n;

  public FactorialSquareCalculator(Integer n) {
    this.n = n;
  }

  @Override
  protected Integer compute() {
    if (n <= 1) { // 有点递归的味道
      return n;
    }
    FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);

    calculator.fork();

    return n * n + calculator.join();
  }
}
