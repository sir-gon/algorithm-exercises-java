package ae.projecteuler;

import ae.projecteuler.helper.BigNum;
import util.Log;

/**
 * Problem 0020.
 *
 * @link Problem definition [[docs/projecteuler/problem0020.md]]
 */
public class Problem0020 {

  private Problem0020() {}

  /** Problem 0020. */
  public static BigNum problem0020(int limit) {
    String log;
    BigNum factorial = BigNum.bigFactorial(limit);

    log = String.format("Factorial of %d!: %s", limit, factorial.toString());
    Log.info(log);

    BigNum result = new BigNum(0).bigSumMany(factorial.toArray());

    log = String.format("Problem 00020 solved: %s", result.toString());
    Log.info(log);

    return result;
  }
}
