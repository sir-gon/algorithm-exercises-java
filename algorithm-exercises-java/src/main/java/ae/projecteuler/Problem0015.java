// CHECKSTYLE.OFF: JavadocParagraph

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

    String log;
    log = String.format("Problem 00015 solved: %d", result);
    logger.info(log);

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
