// CHECKSTYLE.OFF: JavadocParagraph

package projecteuler;

/**
 *
 * {TITLE}
 *
 * https://projecteuler.net/problem=XX
 *
 * {DESCRIPTION}
 *
 * ////////////////////////////////////////////////////////////////////////////
 * Result found:
 * ////////////////////////////////////////////////////////////////////////////
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
