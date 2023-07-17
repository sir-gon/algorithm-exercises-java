// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Longest Collatz sequence
 *
 * https://projecteuler.net/problem=14
 *
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all
 * starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

package ae.projecteuler;

import ae.projecteuler.helper.Collatz;
import java.util.ArrayList;


/**
 * Problem 0013.
 */
public class Problem0014 {

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0013.
   */
  public static Long problem0014(Integer bottom, Integer top) throws Exception {
    if (bottom < 1) {
      throw new Exception("bottom must be a positive integer");
    }
    if (bottom >= top) {
      throw new Exception("top must be and integer, higher than bottom");
    }
    ArrayList<Long> maxSequence = new ArrayList<Long>();

    for (int i = bottom; i < top; i++) {
      long c = i;
      ArrayList<Long> sequence =  new ArrayList<Long>();
      sequence.add(c);
      do {
        c = Collatz.collatz((long) c);
        sequence.add(c);
        // console.log(`sequence of ${i}: ${c}`);
      } while (c != 1);

      logger.fine(String.format("sequence of %d: %s", i, sequence));

      if (sequence.size() > maxSequence.size()) {
        maxSequence = sequence;
      }
    }

    logger.fine(String.format(
        "Large sequence found: %s has %d elements",
        maxSequence,
        maxSequence.size())
    );

    // return firt element
    long result = maxSequence.get(0);

    logger.info(String.format("Problem 00014 solved: %d", result));
    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
