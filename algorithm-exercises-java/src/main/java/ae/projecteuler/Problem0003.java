package ae.projecteuler;

import ae.projecteuler.helper.Divisors;
import ae.projecteuler.helper.NaturalNumber;
import java.util.Arrays;

/**
 * Largest prime factor.
 *
 * @link Problem definition [[docs/projecteuler/problem0003.md]]
 */
public class Problem0003 {

  private Problem0003() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0003.
   */
  public static Long problem0003(Long top) {

    Long[] divs = Divisors.divisors(top);

    // middle position for odd and even cases
    Integer middle = (int) Math.ceil((double) divs.length / 2) - 1;

    String log;
    log = String.format("Divisors of %d: %s", top, Arrays.toString(divs));
    logger.info(log);

    Long maxPrimeFactor = null;
    Integer i = middle;
    // check half divisors, each is Prime? wich is largest?

    while (i >= 0) {
      boolean prime = NaturalNumber.isPrime(divs[i]);

      log = String.format("%d is Prime?: %b", i, prime);
      logger.fine(log);

      if (prime) {
        maxPrimeFactor = divs[i];

        log = String.format("Problem 00003 solved: %d", maxPrimeFactor);
        logger.info(log);

        return maxPrimeFactor;
      }

      i -= 1;
    }

    return null;
  }

}
