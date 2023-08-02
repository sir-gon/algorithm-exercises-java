// CHECKSTYLE.OFF: JavadocParagraph

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
  public static Integer problem0007(Integer top) {
    ArrayList<Integer> primes = new ArrayList<>();
    Integer i = 0;
    Integer j = 2;
    String log;

    while (primes.size() < top) {
      i += 1;
      NaturalNumber number = new NaturalNumber(Long.valueOf(j));
      if (number.isPrime()) {
        primes.add(j);

        log = String.format("Prime found %d put in position: %d", j, primes.size());
        logger.fine(log);
      }

      j = 2 * i + 1;
    }

    log = String.format("primes count: %d", primes.size());
    logger.info(log);

    Integer answer = primes.get(primes.size() - 1);
    Integer cycles = i;

    log = String.format("%d prime number is: %d in %d cycles", top, answer, cycles);
    logger.info(log);

    return answer;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
