// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Factorial digit sum
 *
 * https://projecteuler.net/problem=20
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

package ae.projecteuler;

import ae.projecteuler.helper.BigNum;

/**
 * Problem 0020.
 */
public class Problem0020 {

  private Problem0020() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0020.
   */
  public static BigNum problem0020(int limit) {
    String log;
    BigNum factorial = BigNum.bigFactorial(limit);

    log = String.format("Factorial of %d!: %s", limit, factorial.toString());
    logger.info(log);

    BigNum result = new BigNum(0).bigSumMany(factorial.toArray());

    log = String.format("Problem 00020 solved: %s", result.toString());
    logger.info(log);

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
