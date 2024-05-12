// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

/**
 * Smallest multiple.
 *
 * @link Problem definition [[docs/projecteuler/problem0005.md]]
 */
public class Problem0005Simple {

  private Problem0005Simple() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

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
