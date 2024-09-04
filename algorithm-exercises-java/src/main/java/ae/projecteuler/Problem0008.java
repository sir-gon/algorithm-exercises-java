package ae.projecteuler;

import ae.projecteuler.helper.Product;
import java.util.ArrayList;
import util.CustomLogger;

/**
 * Largest product in a series.
 *
 * @link Problem definition [[docs/projecteuler/problem0008.md]]
 */
public class Problem0008 {

  private Problem0008() {}


  /**
   * Problem template method.
   */
  public static Long problem0008(String number, Integer interval) {
    String[] digits = number.split("");
    Integer bottom = 0;
    Integer top = digits.length;
    Long max = 0L;
    String log;

    for (int i = bottom; i < top - interval; i++) {
      ArrayList<Long> digitsSet = new ArrayList<>();

      for (int j = 0; j < interval; j++) {
        digitsSet.add(Long.parseLong(digits[i + j]));
      }

      Long currentProduct = Product.product(digitsSet.toArray(Long[]::new));
      log = String.format("Product beetwen %d and %d is: %d", i, i + interval, currentProduct);
      CustomLogger.debug(log);

      if (currentProduct > max) {
        max = currentProduct;
      }
    }

    log = String.format("Problem 0008 solved: %d", max);
    CustomLogger.info(log);

    return max;
  }
}
