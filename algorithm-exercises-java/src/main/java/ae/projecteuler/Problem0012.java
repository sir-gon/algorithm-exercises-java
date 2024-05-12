package ae.projecteuler;

import ae.projecteuler.helper.Divisors;

/**
 * Problem 0012.
 *
 * @link Problem definition [[docs/projecteuler/problem0012.md]]
 */
public class Problem0012 {

  private Problem0012() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * Problem 0012.
   */
  public static Long problem0012(Long top) {
    Long count = (long) 0;
    Long triangular = (long) 0;
    Long i = (long) 1;

    Long[] d;
    String log;

    while (count < top) {
      triangular += i;
      d = Divisors.divisors(triangular);

      log = String.format("Triangular number: %d has %d divisors", triangular, d.length);
      logger.fine(log);

      if (d.length > count) {
        count = (long) d.length;
      }

      i += 1;
    }

    log = String.format("Problem 00012 solved: %d", count);
    logger.info(log);

    return count;
  }
}
