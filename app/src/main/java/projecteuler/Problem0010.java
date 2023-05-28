// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Summation of primes
 *
 * https://projecteuler.net/problem=10
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */

package projecteuler;

import java.util.ArrayList;
import projecteuler.helper.NaturalNumber;
import projecteuler.helper.Sum;

/**
 * Summation of primes.
 */
public class Problem0010 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0010.
   */
  public static Long problem0010(Integer bottom, Integer top) {
    ArrayList<Long> primes = new ArrayList<Long>();

    Integer i = bottom;

    do {
      i += 1;

      if (new NaturalNumber(i).isPrime()) {
        primes.add(Long.valueOf(i));
        logger.fine(String.format("Prime found %d put in position: $d", i, primes.size()));
      }
    } while (i < top);

    Long result = Sum.sum(primes.toArray(Long[]::new));

    logger.info(String.format("primes count: %d", primes.size()));
    logger.info(String.format("Sum of primes below %d is: %d}", top, result));

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
