package ae.projecteuler;

import ae.projecteuler.helper.NaturalNumber;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Log;

/**
 * Smallest multiple.
 *
 * @link Problem definition [[docs/projecteuler/problem0005.md]]
 */
public class Problem0005 {

  private Problem0005() {}

  /** countOccurrences. */
  public static Map<Long, Integer> countOccurrences(List<Long> numbers) {
    // Crear un mapa para realizar el recuento de ocurrencias
    Map<Long, Integer> occurrences = new HashMap<>();

    // Contar las ocurrencias de cada número en la lista
    for (Long number : numbers) {
      occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
    }

    return occurrences;
  }

  /** mixOccurrences. */
  public static Map<Long, Integer> mixOccurrences(
      Map<Long, Integer> listA, Map<Long, Integer> listB) {
    Map<Long, Integer> occurrences = new HashMap<>();

    listA.forEach(occurrences::put);

    listB.forEach(
        (keyB, valueB) -> {
          Integer valueA = occurrences.getOrDefault(keyB, null);
          Integer max = (valueA != null && valueA > valueB) ? valueA : valueB;

          occurrences.put(keyB, max);
        });

    return occurrences;
  }

  /** Problem 0005. */
  public static Integer problem0005(Integer bottom, Integer top) {
    String log;
    Integer result = null;

    Map<Long, Integer> minimumPrimeFactorsCollector = new HashMap<>();

    for (int i = bottom; i <= top; i++) {
      NaturalNumber number = new NaturalNumber(Long.valueOf(i));

      Long[] primeFactors = number.primeFactors();

      Map<Long, Integer> primeFactorsCount = countOccurrences(Arrays.asList(primeFactors));

      minimumPrimeFactorsCollector =
          mixOccurrences(minimumPrimeFactorsCollector, primeFactorsCount);

      log = String.format("%s", minimumPrimeFactorsCollector.toString());
      Log.info(log);
    }

    result = 1;
    for (Map.Entry<Long, Integer> me : minimumPrimeFactorsCollector.entrySet()) {
      Long factor = me.getKey();
      Integer quantity = me.getValue();

      result *= (int) Math.pow(factor, quantity);
    }

    log = String.format("Problem 0005 solved: %d", result);
    Log.info(log);

    return result;
  }
}
