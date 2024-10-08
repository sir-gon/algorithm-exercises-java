package ae.projecteuler;

import util.Log;

/**
 * Multiples of 3 and 5.
 *
 * @link Problem definition [[docs/projecteuler/problem0001.md]]
 */
public class Problem0001 {

  private Problem0001() {}

  /**
   * Problem0001.
   */
  public static Integer problem0001(Integer top) {
    Integer result = 0;
    Integer i;

    for (i = 0; i < top; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        String log = String.format("Line result: %d", i);
        Log.debug(log);

        result += i;
      }
    }

    String log = String.format("Problem 0001 solved: %d", result);
    Log.info(log);

    return result;
  }
}
