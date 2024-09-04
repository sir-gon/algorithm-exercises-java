package ae.projecteuler;

import ae.projecteuler.helper.BigNum;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.CustomLogger;

/**
 * Large sum.
 *
 * @link Problem definition [[docs/projecteuler/problem0013.md]]
 */
public class Problem0013 {

  private Problem0013() {}


  /**
   * Problem 0013.
   */
  public static String problem0013(String[] arrayOfNumbers, Integer firtsDigits) {
    BigNum sum = new BigNum(0);
    sum = sum.bigSumMany(arrayOfNumbers);

    List<Integer> first = Arrays.asList(sum.toArray()).subList(0, firtsDigits);

    String numberString = first
        .stream().map(String::valueOf)
        .collect(Collectors.joining(""));


    String log;
    log = String.format("First %d digits of huge sume are %s", firtsDigits, first);
    CustomLogger.info(log);
    log = String.format("Problem 00013 solved: %s", numberString);
    CustomLogger.info(log);

    return numberString;
  }
}
