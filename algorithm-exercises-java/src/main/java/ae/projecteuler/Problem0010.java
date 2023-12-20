package ae.projecteuler;

import ae.projecteuler.helper.NaturalNumber;
import ae.projecteuler.helper.Sum;
import java.util.ArrayList;

/**
 * Summation of primes.
 *
 * @link Problem definition [[docs/projecteuler/problem0010.md]]
 */
public class Problem0010 {

  private Problem0010() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0010.
   */
  public static Long problem0010(Long bottom, Long top) {
    ArrayList<Long> primes = new ArrayList<>();

    String log;
    Long i = bottom;

    do {
      i += 1;

      if (new NaturalNumber(i).isPrime()) {
        primes.add(i);
        log = String.format("Prime found %d put in position: %d", i, primes.size());
        logger.fine(log);
      }
    } while (i < top);

    Long result = Sum.sum(primes.toArray(Long[]::new));

    log = String.format("primes count: %d", primes.size());
    logger.info(log);
    log = String.format("Sum of primes below %d is: %d", top, result);
    logger.info(log);

    return result;
  }
}
