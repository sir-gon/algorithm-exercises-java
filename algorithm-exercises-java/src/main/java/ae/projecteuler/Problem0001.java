package ae.projecteuler;

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * Multiples of 3 and 5.
 *
 * @link Problem definition [[docs/projecteuler/problem0001.md]]
 */
public class Problem0001 {

  private Problem0001() {}

  static Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem0001.
   */
  public static Integer problem0001(Integer top) {
    Integer result = 0;
    Integer i;

    for (i = 0; i < top; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        String log = MessageFormat.format("Line result: {0}", i);
        logger.fine(log);

        result += i;
      }
    }

    String log = MessageFormat.format("Problem 00001 solved: {0}", result);
    logger.info(log);

    return result;
  }
}
