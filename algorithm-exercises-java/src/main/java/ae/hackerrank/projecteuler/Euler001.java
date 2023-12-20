package ae.hackerrank.projecteuler;

/**
 * Multiples of 3 and 5.
 *
 * @link Problem definition [[docs/hackerrank/projecteuler/euler001.md]]
 */
public class Euler001 {

  private Euler001() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Greatest common divisor.
   */
  private static Long gcd(Integer a, Integer b) {
    if (a == 0) {
      return (long) b;
    }

    return gcd(b % a, a);
  }

  /**
   * Sum of Arithmetic Progression series.
   */
  private static Long sumOfArithmeticProgression(Long numberOfTerms, Long distance) {
    long n = numberOfTerms / distance;

    return (long) ((n) * (1 + n) * distance / 2);
  }

  /**
   * Multiples of 3 and 5.
   */
  public static Long euler001(Integer a, Integer b, Integer n) {
    Long result = null;

    n = n - 1;
    Long lcm = (a * b) / gcd(a, b);

    result = sumOfArithmeticProgression((long) n, (long) a)
      + sumOfArithmeticProgression((long) n, (long) b)
      - sumOfArithmeticProgression((long) n, lcm);

    String log = String.format("Problem 001 solved: %d", result);
    logger.info(log);

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
