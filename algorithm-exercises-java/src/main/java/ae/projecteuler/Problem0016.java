// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import ae.projecteuler.helper.BigNum;

/**
 * Problem 0016.
 */
public class Problem0016 {

  private Problem0016() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0016.
   */
  public static String problem0016(int base, int exponent) {
    BigNum power = new BigNum(base).bigPower(exponent);

    String log;

    log = String.format("Digits of power found: %s", power.toString());
    logger.info(log);

    String[] digits = power.toString().split("");

    BigNum result = new BigNum(0);
    result.bigSumMany(digits);

    log = String.format("Problem 00016 solved: %s", result.toString());
    logger.info(log);

    return result.toString();
  }
}

//CHECKSTYLE.ON: JavadocParagraph
