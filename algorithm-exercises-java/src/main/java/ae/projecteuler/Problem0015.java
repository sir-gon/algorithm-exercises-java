// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Lattice paths
 *
 * https://projecteuler.net/problem=15
 *
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */

package ae.projecteuler;

/**
   * Problem 0015.
 */
public class Problem0015 {

  private Problem0015() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0015.
   */
  public static Long problem0015(Integer gridSide) {

    Long[][] grid = new Long[gridSide + 1][gridSide + 1];

    // initialization
    for (int i = 0; i <= gridSide; i++) {
      for (int j = 0; j <= gridSide; j++) {
        grid[i][j] = 1L;
      }
    }

    // vertex computing
    for (int i = 1; i <= gridSide; i++) {
      for (int j = 1; j <= gridSide; j++) {
        long upperParent = grid[i - 1][j];
        long leftParent = grid[i][j - 1];

        grid[i][j] = upperParent + leftParent;
      }
    }

    Long result = grid[gridSide][gridSide];

    logger.info(String.format("Problem 00015 solved: %d", result));

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
