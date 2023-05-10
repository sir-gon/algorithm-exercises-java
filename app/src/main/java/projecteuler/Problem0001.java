// CHECKSTYLE.OFF: JavadocParagraph

package projecteuler;

/**
 * Multiples of 3 and 5
 *
 * https://projecteuler.net/problem=1
 *
 * If we list all the natural numbers below 10 that are multiples
 * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem0001 {

  /**
   * Problem template method.
   */
  public Integer problem0001(Integer top) {
    Integer result = 0;
    Integer i;

    for (i = 0; i < top; i++) {
      if (i % 3 == 0 || i % 5 == 0) {

        result += i;
      }
    }

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
