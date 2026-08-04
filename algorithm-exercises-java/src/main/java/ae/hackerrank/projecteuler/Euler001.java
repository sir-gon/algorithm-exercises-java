package ae.hackerrank.projecteuler;

import util.Log;

/**
 * Multiples of 3 and 5.
 *
 * @link Problem definition [[docs/hackerrank/projecteuler/euler001.md]]
 */
public class Euler001 {

  private Euler001() {}

  /** Greatest common divisor. */
  static Long gcd(Integer a, Integer b) {
    if (a == 0 || b == 0) {
      return (long) (a + b);
    }

    return gcd(b % a, a);
  }

  /** Least common multiple. */
  static Long lcm(Integer a, Integer b) {
    Long gcdValue = gcd(a, b);
    return gcdValue == 0L ? 0L : ((long) a * b) / gcdValue;
  }

  /** Sum of Arithmetic Progression series. */
  static Long sumOfArithmeticProgression(Long numberOfTerms, Long distance) {
    if (distance == 0L || numberOfTerms <= 0L) {
      return 0L;
    }

    long n = numberOfTerms / distance;
    if (n <= 0L) {
      return 0L;
    }

    return (long) (n * (1 + n) * distance / 2);
  }

  /** Multiples of 3 and 5. */
  public static Long euler001(Integer a, Integer b, Integer n) {

    Long result = null;

    n = n - 1;
    if (n <= 0) {
      return 0L;
    }

    Long lcmValue = lcm(a, b);

    result =
        sumOfArithmeticProgression((long) n, (long) a)
            + sumOfArithmeticProgression((long) n, (long) b)
            - sumOfArithmeticProgression((long) n, lcmValue);

    String log = String.format("Problem 001 solved: %d", result);
    Log.info(log);

    return result;
  }
}

// CHECKSTYLE.ON: JavadocParagraph
