// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Largest palindrome product
 *
 * https://projecteuler.net/problem=4
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

/// ////////////////////////////////////////////////////////////////////////////
// NOTES ABOUT THE SOLUTION:
// This solution cycles to test all pairs of factors between 111 and 999 that
// meet the condition of generating a palindrome and saves the largest found.
// I think there must be another optimal solution to avoid testing all cases
// cutting the loop around the largest factor pair
// That's why I thought about doing the loop from highest to lowest.
/// ////////////////////////////////////////////////////////////////////////////

/// ////////////////////////////////////////////////////////////////////////////

package projecteuler;

import projecteuler.helper.Palindrome;

/**
 * Largest palindrome product.
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
