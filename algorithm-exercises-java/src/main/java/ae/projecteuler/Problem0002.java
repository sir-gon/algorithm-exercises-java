package ae.projecteuler;

import util.CustomLogger;

/**
 * Even Fibonacci numbers.
 *
 * @link Problem definition [[docs/projecteuler/problem0002.md]]
 */
public class Problem0002 {

  private Problem0002() {}

  /**
   * Problem template method.
   */
  public static Integer problem0002(int top) {

    int i = 0;
    int last1 = 1;
    int last2 = 0;
    int evenSum = 0;

    int fibo = 0;
    do {
      fibo = last2 + last1;

      String log = String.format("Fibonacci(%d) = %d", i, fibo);
      CustomLogger.debug(log);

      if (fibo % 2 == 0) {
        evenSum += fibo;
      }

      // next keys:
      last2 = last1;
      last1 = fibo;
      i += 1;
    } while (fibo < top);

    String log = String.format("Problem 0002 result: %d", evenSum);
    CustomLogger.info(log);

    return evenSum;
  }

}
