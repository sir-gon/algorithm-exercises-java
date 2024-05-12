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
 * Amicable numbers.
 *
 * @link Problem definition [[docs/projecteuler/problem0021.md]]
 */
public class Problem0021 {

  private Problem0021() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * Problem 0021.
   */
  public static String problem0021(int start, int limit) {

    Map<String, String> properDivisorsSums = new LinkedHashMap<>();

    for (int i = start; i <= limit; i++) {
      String key = String.valueOf(i);

      List<Long> integers = Arrays.asList(Divisors.divisors((long) i));
      Long sum = integers.stream().reduce(0L, (a, b) -> a + b) - i;

      properDivisorsSums.put(key, String.valueOf(sum));
    }

    ArrayList<String> amicableNumbers = new ArrayList<>();

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

    String log;

    log = String.format("Amicable numbers: %s", amicableNumbers);
    logger.info(log);

    BigNum result = new BigNum(0).bigSumMany(amicableNumbers.toArray(String[]::new));

    log = String.format("Problem 00021 solved: %s", result);
    logger.info(log);

    return result.toString();
  }
}
