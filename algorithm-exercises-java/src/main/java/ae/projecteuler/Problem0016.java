package ae.projecteuler;

import ae.projecteuler.helper.BigNum;
import util.Log;


/**
 * Problem 0016.
 *
 * @link Problem definition [[docs/projecteuler/problem0016.md]]
 */
public class Problem0016 {

  private Problem0016() {}


  /**
   * Problem 0016.
   */
  public static String problem0016(int base, int exponent) {
    BigNum power = new BigNum(base).bigPower(exponent);

    String log;

    log = String.format("Digits of power found: %s", power.toString());
    Log.info(log);

    String[] digits = power.toString().split("");

    BigNum result = new BigNum(0);
    result.bigSumMany(digits);

    log = String.format("Problem 00016 solved: %s", result.toString());
    Log.info(log);

    return result.toString();
  }
}
