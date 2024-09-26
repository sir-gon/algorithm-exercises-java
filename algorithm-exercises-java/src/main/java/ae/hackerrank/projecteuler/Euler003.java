package ae.hackerrank.projecteuler;

/**
 * Even Fibonacci numbers.
 *
 * @link Problem definition [[docs/hackerrank/projecteuler/euler003.md]]
 */
public class Euler003 {

  private Euler003() {}

  private static Long primeFactor(Long n) {
    if (n < 2) {
      throw new IllegalArgumentException("n must be greater than 2");
    }

    Long divisor = n;
    Long maxPrimeFactor = null;

    int i = 2;
    while (i <= Math.sqrt(divisor)) {
      if (divisor % i == 0) {
        divisor = divisor / i;
        maxPrimeFactor = divisor;
      } else {
        i += 1;
      }
    }

    if (maxPrimeFactor == null) {
      return n;
    }

    return maxPrimeFactor;
  }

  /**
   * Even Fibonacci numbers.
   */
  public static Long euler003(long n) {
    return primeFactor(n);
  }
}

//CHECKSTYLE.ON: JavadocParagraph
