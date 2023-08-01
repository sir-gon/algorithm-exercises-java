// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import ae.projecteuler.helper.Divisors;
import ae.projecteuler.helper.NaturalNumber;
import java.util.Arrays;


/**
 * Largest prime factor
 *
 * https://projecteuler.net/problem=3
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
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

//CHECKSTYLE.ON: JavadocParagraph
