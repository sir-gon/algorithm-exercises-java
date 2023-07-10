// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Lexicographic Permutations
 *
 * https://projecteuler.net/problem=24
 *
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem 0024.
 */
public class Problem0024 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  static Long factorial(long n) {
    long out = 1L;
    while (n > 1) {
      out *= n--;
    }
    return out;
  }

  static String permute(String symbols, long target) {

    ArrayList<String> choices =
        new ArrayList<String>(Arrays.asList(String.valueOf(symbols).split("")));
    String answer = "";
    long min = 0;

    while (choices.size() > 0) {
      int index = 0;
      long combos = Problem0024.factorial(choices.size() - 1);
      min += combos;
      while (target > min) {
        index += 1;
        min += combos;
      }
      answer += choices.remove(index);
      min -= combos;
    }

    return answer;
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

//CHECKSTYLE.ON: JavadocParagraph
