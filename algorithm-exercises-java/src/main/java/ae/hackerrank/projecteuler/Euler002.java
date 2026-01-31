package ae.hackerrank.projecteuler;

import util.Log;

/**
 * Even Fibonacci numbers.
 *
 * @link Problem definition [[docs/hackerrank/projecteuler/euler002.md]]
 */
public class Euler002 {

  private Euler002() {}

  private static Long fibbo(Integer n) {
    Long total = 0L;
    Long fibo;
    Long fibo1 = 1L;
    Long fibo2 = 1L;

    while (fibo1 + fibo2 < n) {
      fibo = fibo1 + fibo2;
      fibo1 = fibo2;
      fibo2 = fibo;

      if (fibo % 2 == 0) {
        total += fibo;
      }
    }

    return total;
  }

  /** Even Fibonacci numbers. */
  public static Long euler002(Integer n) {
    Long result = fibbo(n);

    String log = String.format("Problem 002 solved: %d", result);
    Log.info(log);

    return result;
  }
}

// CHECKSTYLE.ON: JavadocParagraph
