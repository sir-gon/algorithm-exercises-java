package ae.hackerrank.warmup;

import java.util.List;

/**
 * VeryBigSum.
 *
 * @link Problem definition [[docs/hackerrank/warmup/a_very_big_sum.md]]
 */
public class VeryBigSum {

  private VeryBigSum() {
  }

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * aVeryBigSum.
   */
  public static long aVeryBigSum(List<Long> ar) {
    long total = 0L;

    for (long x : ar) {
      total += x;
    }

    return total;
  }
}
