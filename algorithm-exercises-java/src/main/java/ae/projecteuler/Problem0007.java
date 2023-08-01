// CHECKSTYLE.OFF: JavadocParagraph
/**
 * 10001st prime
 *
 * https://projecteuler.net/problem=7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

package ae.projecteuler;

import ae.projecteuler.helper.NaturalNumber;
import java.util.ArrayList;


/**
 * 10001st prime.
 */
public class Problem0007 {

  private Problem0007() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0007.
   */
  public static Integer problem0007(Integer _top) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    Integer i = 0;
    Integer j = 2;

    while (primes.size() < _top) {
      i += 1;
      NaturalNumber number = new NaturalNumber(Long.valueOf(j));
      if (number.isPrime()) {
        primes.add(j);

        logger.fine(String.format("Prime found %d put in position: %d", j, primes.size()));
      }

      j = 2 * i + 1;
    }

    logger.info(String.format("primes count: %d", primes.size()));

    Integer answer = primes.get(primes.size() - 1);
    Integer cycles = i;

    logger.info(String.format("%d prime number is: %d in %d cycles", _top, answer, cycles));

    return answer;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
