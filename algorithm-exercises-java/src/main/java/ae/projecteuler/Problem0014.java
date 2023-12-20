package ae.projecteuler;

import ae.projecteuler.helper.Collatz;
import java.util.ArrayList;


/**
 * Longest Collatz sequence.
 *
 * @link Problem definition [[docs/projecteuler/problem0014.md]]
 */
public class Problem0014 {
  private Problem0014() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0013.
   */
  public static Long problem0014(Integer bottom, Integer top) throws IllegalArgumentException {
    String log;

    if (bottom < 1) {
      throw new IllegalArgumentException("bottom must be a positive integer");
    }
    if (bottom >= top) {
      throw new IllegalArgumentException("top must be and integer, higher than bottom");
    }
    ArrayList<Long> maxSequence = new ArrayList<>();

    for (int i = bottom; i < top; i++) {
      long c = i;
      ArrayList<Long> sequence =  new ArrayList<>();
      sequence.add(c);
      do {
        c = Collatz.collatz(c);
        sequence.add(c);
      } while (c != 1);

      log = String.format("sequense of %d: %s", i, sequence);
      logger.fine(log);

      if (sequence.size() > maxSequence.size()) {
        maxSequence = sequence;
      }
    }

    log = String.format(
        "Large sequence found: %s has %d elements",
        maxSequence,
        maxSequence.size());
    logger.fine(log);

    // return firt element
    long result = maxSequence.get(0);

    logger.info(() -> String.format("Problem 00014 solved: %d", result));
    return result;
  }
}
