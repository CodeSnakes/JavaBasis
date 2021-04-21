package Other;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yichangkong
 * @create 2020-09-04-14:25
 */
public class MyAtomicLong {
  public static void main(String[] args) {
    //
    AtomicLong max = new AtomicLong(10000);
      System.out.println(max.decrementAndGet());
      System.out.println(max.decrementAndGet());

  }
}
