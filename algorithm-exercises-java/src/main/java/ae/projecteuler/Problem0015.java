package ae.projecteuler;

/**
 * Lattice paths.
 *
 * @link Problem definition [[docs/projecteuler/problem0015.md]]
 */
public class Problem0015 {

  private Problem0015() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * Problem 0015.
   */
  public static Long problem0015(Integer gridSide) {

    int limit = gridSide + 1;
    Long[][] grid = new Long[limit][limit];

    // initialization
    for (int i = 0; i <= gridSide; i++) {
      for (int j = 0; j <= gridSide; j++) {
        grid[i][j] = 1L;
      }
    }

    // vertex computing
    for (int i = 1; i < limit; i++) {
      for (int j = 1; j < limit; j++) {
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
