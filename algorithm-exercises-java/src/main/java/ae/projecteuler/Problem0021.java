// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Amicable numbers
 *
 * https://projecteuler.net/problem=21
 *
 * Let d(n) be defined as the sum of proper divisors of n
 * (numbers less than n which divide evenly into n).
 *
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are
 * an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10,
 * 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 *
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

package ae.projecteuler;

import ae.projecteuler.helper.BigNum;
import ae.projecteuler.helper.Divisors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



/**
 * Problem 0021.
 */
public class Problem0021 {

  private Problem0021() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0021.
   */
  public static String problem0021(int start, int limit) {

    Map<String, String> properDivisorsSums = new LinkedHashMap<String, String>();

    for (int i = start; i <= limit; i++) {
      String key = String.valueOf(i);

      List<Long> integers = Arrays.asList(Divisors.divisors((long) i));
      Long sum = integers.stream().reduce(0L, (a, b) -> a + b) - i;

      properDivisorsSums.put(key, String.valueOf(sum));
    }

    ArrayList<String> amicableNumbers = new ArrayList<String>();

    Set<Entry<String, String>> entries = properDivisorsSums.entrySet();
    for (Map.Entry<String, String> mapEntry : entries) {
      String key = mapEntry.getKey();
      String value = mapEntry.getValue();

      if (
          !key.equals(value)
          && key.equals(properDivisorsSums.get(value))
      ) {
        amicableNumbers.add(key);
      }

    }

    logger.info(String.format("Amicable numbers: %s", amicableNumbers));

    BigNum result = new BigNum(0).bigSumMany(amicableNumbers.toArray(String[]::new));

    logger.info(String.format("Problem 00021 solved: %s", result));

    return result.toString();
  }
}
//CHECKSTYLE.ON: JavadocParagraph
