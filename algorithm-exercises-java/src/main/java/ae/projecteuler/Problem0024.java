package ae.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem 0024.
 *
 * @link Problem definition [[docs/projecteuler/problem0024.md]]
 */
public class Problem0024 {

  private Problem0024() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  static Long factorial(long n) {
    long out = 1L;
    while (n > 1) {
      out *= n--;
    }
    return out;
  }

  static String permute(String symbols, long target) {

    StringBuilder answer = new StringBuilder();
    ArrayList<String> choices =
        new ArrayList<>(Arrays.asList(String.valueOf(symbols).split("")));
    long min = 0;

    while (!choices.isEmpty()) {
      int index = 0;
      long combos = Problem0024.factorial((long) choices.size() - 1);
      min += combos;
      while (target > min) {
        index += 1;
        min += combos;
      }
      answer.append(choices.remove(index));
      min -= combos;
    }

    return answer.toString();
  }

  /**
   * Problem 0024.
   */
  public static String problem0024(
      String inputElements,
      Integer inputPermutationToFind
  ) {
    return Problem0024.permute(inputElements, inputPermutationToFind);
  }
}
