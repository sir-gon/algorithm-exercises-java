package ae.hackerrank.interview_preparation_kit.miscellaneous;

/**
 * TimeComplexityPrimality.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/miscellaneous/ctci-big-o.md]]
 */
public class TimeComplexityPrimality {

  private static final String PRIME = "Prime";
  private static final String NOT_PRIME = "Not prime";

  private TimeComplexityPrimality() {}

  private static Integer primeFactor(int n) {
    if (n < 2) {
      return null;
    }

    int divisor = n;
    Integer maxPrimeFactor = null;
    int i = 2;
    while (i <= Math.sqrt(divisor)) {
      if (0 == divisor % i) {
        divisor = divisor / i;
        maxPrimeFactor = i;
      } else {
        i += 1;
      }
    }

    if (maxPrimeFactor == null) {
      return n;
    }

    return maxPrimeFactor;
  }

  /** primality. */
  public static String primality(int n) {
    Integer pf = primeFactor(n);

    return (pf == null || pf != n) ? NOT_PRIME : PRIME;
  }
}
