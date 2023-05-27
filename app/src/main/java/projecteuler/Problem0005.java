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

package projecteuler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import projecteuler.helper.NaturalNumber;

/**
 * Smallest multiple.
 */
public class Problem0005 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  /**
   * countOccurrences.
   */
  public static Map<Integer, Integer> countOccurrences(List<Integer> numbers) {
    // Crear un mapa para realizar el recuento de ocurrencias
    Map<Integer, Integer> occurrences = new HashMap<>();

    // Contar las ocurrencias de cada número en la lista
    for (int number : numbers) {
      occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
    }

    // Convertir el mapa en una lista de pares (número, cantidad)
    // List<Map.Entry<Integer, Integer>> result = new ArrayList<>(occurrences.entrySet());

    return occurrences;
  }

  /***
   * mixOccurrences.
   */
  public static Map<Integer, Integer> mixOccurrences(
      Map<Integer, Integer> listA,
      Map<Integer, Integer> listB) {
    Map<Integer, Integer> occurrences = new HashMap<>();

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
   * Problem 0005 (brute force way).
   */
  public static Integer problem0005(Integer _bottom, Integer _top) {
    Integer result = null;
    Integer cycles = 0;

    Map<Integer, Integer> minimumPrimeFactorsCollector = new HashMap<>();

    for (int i = _bottom; i <= _top; i++) {
      NaturalNumber number = new NaturalNumber(i);

      Integer[] primeFactors = number.primeFactors();
      cycles += number.getNextPrimeFactorCycles();

      Map<Integer, Integer> primeFactorsCount = countOccurrences(Arrays.asList(primeFactors));

      minimumPrimeFactorsCollector = mixOccurrences(
          minimumPrimeFactorsCollector,
          primeFactorsCount
      );

      logger.info(String.format("%s", minimumPrimeFactorsCollector.toString()));
    }

    result = 1;
    minimumPrimeFactorsCollector.forEach((factor, quantity) -> {
    });
    //way 2 (java 7 Method)
    for (Map.Entry<Integer, Integer> me : minimumPrimeFactorsCollector.entrySet()) {
      Integer factor = me.getKey();
      Integer quantity = me.getValue();

      result *= (int) Math.pow((double) factor, (double) quantity);
    }

    logger.info(String.format("Problem 00005 solved: %d", result));

    return result;
  }

}

//CHECKSTYLE.ON: JavadocParagraph
