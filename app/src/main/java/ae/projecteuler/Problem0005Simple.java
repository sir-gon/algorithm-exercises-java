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

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0005.
   */
  public static Integer problem0005(Integer _bottom, Integer _top, Integer _startFrom) {
    Integer found = null;
    Boolean fail;
    Integer i;
    Integer test = _startFrom;

    do {
      i = 2;
      fail = false;
      do {
        fail = test % i != 0;

        if (fail) {
          logger.fine(String.format("Fail %d not divisible by %d", test, i));
        } else {
          logger.fine(String.format("Testing: %d divisible by %d", test, i));
        }

        i += 1;
      } while (i <= _top && !fail);

      if (!fail) {
        found = test;
      }

      fail = false;
      test += 1;
    } while (found == null);

    logger.info(String.format("Problem 00005 solved: %d", found));

    return found;
  }

}

//CHECKSTYLE.ON: JavadocParagraph
