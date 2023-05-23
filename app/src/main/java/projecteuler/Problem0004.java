// CHECKSTYLE.OFF: JavadocParagraph

package projecteuler;

import projecteuler.helper.Palindrome;

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

public class Problem0004 {

  static java.util.logging.Logger logger = projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem template method.
   */
  public static Integer problem0004(Integer _bottom, Integer _top) {
    Integer i;
    Integer j;
    Integer foundi = null;
    Integer foundj = null;
    Integer foundPalindrome = null;

    // Find all cases
    Integer cycles = 0;

    i = _top;
    while (i >= _bottom) {
      j = i;
      while (j >= _bottom && (foundj == null || j >= foundj)) {
        cycles += 1;

        if (Palindrome.isPalindrome(Long.valueOf(j * i))) {
          logger.fine(String.format("FOUND: %d x %d = %d is Palindrome", i, j, i * j));

          if (foundPalindrome == null || i * j > foundPalindrome) {
            foundi = i;
            foundj = j;
            foundPalindrome = i * j;
          }
        } else {
          // logger.fine(String.format("FOUND: %d x %d = %d is NOT Palindrome", i, j, i * j));
        }

        j -= 1;
      }

      i -= 1;
    }

    logger.info(
        String.format("Problem 0004 Largest Palindrome  => %d 𝗑 %d = %d in %d cycles",
          foundi,
          foundj,
          foundPalindrome,
          cycles));

    return foundPalindrome;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
