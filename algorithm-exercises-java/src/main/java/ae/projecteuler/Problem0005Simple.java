// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Smallest multiple
 *
 * https://projecteuler.net/problem=5
 *
 *
 * 2520 is the smallest number that can be divided by each of the
 * numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all
 * of the numbers from 1 to 20?
 */

package ae.projecteuler;

/**
 * Smallest multiple.
 */
public class Problem0005Simple {

  private Problem0005Simple() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0005.
   */
  public static Integer problem0005(Integer bottom, Integer top, Integer startFrom) {
    Integer found = null;
    boolean fail;
    String log;
    Integer i;
    Integer test = startFrom;

    do {
      i = bottom;
      do {
        fail = test % i != 0;

        if (fail) {
          log = String.format("Fail %d not divisible by %d", test, i);
          logger.fine(log);
        } else {
          log = String.format("Testing: %d divisible by %d", test, i);
          logger.fine(log);
        }

        i += 1;
      } while (i <= top && !fail);

      if (!fail) {
        found = test;
      }

      test += 1;
    } while (found == null);

    log = String.format("Problem 00005 solved: %d", found);
    logger.info(log);

    return found;
  }

}

//CHECKSTYLE.ON: JavadocParagraph
