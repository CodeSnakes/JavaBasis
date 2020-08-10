package Concurrent.threadsafety.mathutils;

import java.math.BigInteger;

/**
 * @author yichangkong
 * @create 2020-08-09-17:28
 * readme£º
 */
public class MathUtils {
  public static BigInteger factorial(int number) {
    BigInteger f = new BigInteger("1");
    for (int i = 2; i < number; i++) {
      //
      f = f.multiply(BigInteger.valueOf(i));
    }
    return f;
  }
}
