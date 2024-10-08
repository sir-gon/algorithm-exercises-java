package ae.projecteuler;

import util.Log;

/**
 * Lattice paths.
 *
 * @link Problem definition [[docs/projecteuler/problem0015.md]]
 */
public class Problem0015 {

  private Problem0015() {}


  /**
   * Problem 0015.
   */
  public static Long problem0015(Integer gridSide) {
    int limit;

    if (gridSide <= 0) {
      limit = 0;
    } else {
      limit = gridSide + 1;
    }

    Long[][] grid = new Long[limit][limit];

    // initialization
    for (int i = 0; i < limit; i++) {
      for (int j = 0; j < limit; j++) {
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

    Long result;
    if (grid.length > 0) {
      result = grid[grid.length - 1][grid.length - 1];
    } else {
      result = 0L;
    }

    String log;
    log = String.format("Problem 00015 solved: %d", result);
    Log.info(log);

    return result;
  }
}
