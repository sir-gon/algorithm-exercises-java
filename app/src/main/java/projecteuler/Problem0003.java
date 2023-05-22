// CHECKSTYLE.OFF: JavadocParagraph

package projecteuler;

import projecteuler.helper.Divisors;
import projecteuler.helper.Prime;

/**
 *
 * {TITLE}
 *
 * https://projecteuler.net/problem=XX
 *
 * {DESCRIPTION}
 *
 * ////////////////////////////////////////////////////////////////////////////
 * Result found:
 * ////////////////////////////////////////////////////////////////////////////
 */

public class Problem0003 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem template method.
   */
  public static Long problem0003(Long _top) {

    Long[] divs = Divisors.divisors(_top);

    // middle position for odd and even cases
    Integer middle = (int) Math.ceil(divs.length / 2) - 1;


    logger.info(String.format("Divisors of %d: %s", _top, divs.toString()));

    Long maxPrimeFactor = null;
    Integer i = middle;
    // check half divisors, each is Prime? wich is largest?

    while (i >= 0) {
      Boolean prime = Prime.isPrime(divs[i]);

      logger.fine(String.format("%d is Prime?: %b", i, prime));

      if (prime) {
        maxPrimeFactor = divs[i];
        logger.info(String.format("Problem 00003 solved: %d", maxPrimeFactor));

        return maxPrimeFactor;
      }

      i -= 1;
    }

    return null;
  }

}

//CHECKSTYLE.ON: JavadocParagraph
