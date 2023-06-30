// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Large sum
 *
 * https://projecteuler.net/problem=13
 *
 * Work out the first ten digits of the sum of the following
 * one-hundred 50-digit numbers.
 *
 * See: src/main/java/projecteuler/data/Problem0013Data.java
 */

package projecteuler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import projecteuler.helper.BigNum;

/**
 * Problem 0013.
 */
public class Problem0013 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0013.
   */
  public static String problem0013(String[] arrayOfNumbers, Integer firtsDigits) {
    BigNum sum = new BigNum(0);

    sum = sum.bigSumMany(arrayOfNumbers);

    // logger.fine(String.format("Sum: %d", sum));

    List<Integer> first = Arrays.asList(sum.toArray()).subList(0, firtsDigits);

    String numberString = first
        .stream().map(String::valueOf)
        .collect(Collectors.joining(""));


    logger.info(String.format("First %d digits of huge sume are %s", firtsDigits, first));
    logger.info(String.format("Problem 00013 solved: %s", numberString));

    return numberString;

  }
}

//CHECKSTYLE.ON: JavadocParagraph
