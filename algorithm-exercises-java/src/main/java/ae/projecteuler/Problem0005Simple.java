// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import util.Log;

/**
 * Smallest multiple.
 *
 * @link Problem definition [[docs/projecteuler/problem0005.md]]
 */
public class Problem0005Simple {

  private Problem0005Simple() {}

  /** Problem 0005. */
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
          Log.debug(log);
        } else {
          log = String.format("Testing: %d divisible by %d", test, i);
          Log.debug(log);
        }

        i += 1;
      } while (i <= top && !fail);

      if (!fail) {
        found = test;
      }

      test += 1;
    } while (found == null);

    log = String.format("Problem 00005 solved: %d", found);
    Log.info(log);

    return found;
  }
}

// CHECKSTYLE.ON: JavadocParagraph
