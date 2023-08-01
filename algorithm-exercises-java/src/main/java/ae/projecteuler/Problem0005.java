// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Smallest multiple
 *
 * https://projecteuler.net/problem=5
 *
 *
 * 2520 is the smallest number that can be divided by each of the
 * numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all
 * of the numbers from 1 to 20?
 */

package ae.projecteuler;

import ae.projecteuler.helper.NaturalNumber;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Smallest multiple.
 */
public class Problem0005 {

  private Problem0005() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * countOccurrences.
   */
  public static Map<Long, Integer> countOccurrences(List<Long> numbers) {
    // Crear un mapa para realizar el recuento de ocurrencias
    Map<Long, Integer> occurrences = new HashMap<>();

    // Contar las ocurrencias de cada número en la lista
    for (Long number : numbers) {
      occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
    }

    return occurrences;
  }

  /***
   * mixOccurrences.
   */
  public static Map<Long, Integer> mixOccurrences(
      Map<Long, Integer> listA,
      Map<Long, Integer> listB) {
    Map<Long, Integer> occurrences = new HashMap<>();

    listA.forEach((key, value) -> {
      occurrences.put(key, value);
    });

    listB.forEach((keyB, valueB) -> {
      Integer valueA = occurrences.getOrDefault(keyB, null);
      Integer max = (valueA != null && valueA > valueB) ? valueA : valueB;

      occurrences.put(keyB, max);
    });

    return occurrences;
  }


  /**
   * Problem 0005.
   */
  public static Integer problem0005(Integer _bottom, Integer _top) {
    Integer result = null;
    Integer cycles = 0;

    Map<Long, Integer> minimumPrimeFactorsCollector = new HashMap<>();

    for (int i = _bottom; i <= _top; i++) {
      NaturalNumber number = new NaturalNumber(Long.valueOf(i));

      Long[] primeFactors = number.primeFactors();
      cycles += number.getNextPrimeFactorCycles();

      Map<Long, Integer> primeFactorsCount = countOccurrences(Arrays.asList(primeFactors));

      minimumPrimeFactorsCollector = mixOccurrences(
          minimumPrimeFactorsCollector,
          primeFactorsCount
      );

      logger.info(String.format("%s", minimumPrimeFactorsCollector.toString()));
    }

    result = 1;
    for (Map.Entry<Long, Integer> me : minimumPrimeFactorsCollector.entrySet()) {
      Long factor = me.getKey();
      Integer quantity = me.getValue();

      result *= (int) Math.pow((double) factor, (double) quantity);
    }

    logger.info(String.format("Problem 00005 solved: %d", result));

    return result;
  }

}

//CHECKSTYLE.ON: JavadocParagraph
