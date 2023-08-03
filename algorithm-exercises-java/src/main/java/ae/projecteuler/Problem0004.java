// CHECKSTYLE.OFF: JavadocParagraph

/// ////////////////////////////////////////////////////////////////////////////
// NOTES ABOUT THE SOLUTION:
// This solution cycles to test all pairs of factors between 111 and 999 that
// meet the condition of generating a palindrome and saves the largest found.
// I think there must be another optimal solution to avoid testing all cases
// cutting the loop around the largest factor pair
// That's why I thought about doing the loop from highest to lowest.
/// ////////////////////////////////////////////////////////////////////////////

package ae.projecteuler;

import ae.projecteuler.helper.Palindrome;
import java.text.MessageFormat;

/**
 * Largest palindrome product.
 */
public class Problem0004 {

  private Problem0004() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem template method.
   */
  public static Integer problem0004(int bottom, int top) {
    Integer foundi = null;
    Integer foundj = null;
    Integer foundPalindrome = null;

    // Find all cases
    Integer cycles = 0;

    int i = top;
    int j;
    while (i >= bottom) {
      j = i;
      while (j >= bottom && (foundj == null || j >= foundj)) {
        cycles += 1;

        if (Palindrome.isPalindrome(Long.valueOf((long) j * (long) i))) {
          String log = MessageFormat.format("FOUND: {0} x {1} = {2} is Palindrome", i, j, i * j);
          logger.fine(log);

          if (foundPalindrome == null || i * j > foundPalindrome) {
            foundi = i;
            foundj = j;
            foundPalindrome = i * j;
          }
        }

        j -= 1;
      }

      i -= 1;
    }

    String log = MessageFormat.format(
        "Problem 0004 Largest Palindrome  => {0} 𝗑 {1} = {2} in {3} cycles",
        foundi,
        foundj,
        foundPalindrome,
        cycles);

    logger.info(log);

    return foundPalindrome;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
