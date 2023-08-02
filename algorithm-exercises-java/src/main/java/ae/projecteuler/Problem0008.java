// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import ae.projecteuler.helper.Product;
import java.util.ArrayList;


/**
 * Largest product in a series.
 */
public class Problem0008 {

  private Problem0008() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

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
      logger.fine(log);

      if (currentProduct > max) {
        max = currentProduct;
      }
    }

    log = String.format("Problem 0008 solved: %d", max);
    logger.info(log);

    return max;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
