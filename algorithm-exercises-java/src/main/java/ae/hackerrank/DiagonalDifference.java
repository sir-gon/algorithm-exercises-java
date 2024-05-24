package ae.hackerrank;

import java.util.List;

/**
 * Diagonal Difference.
 *
 * @link Problem definition [[docs/hackerrank/warmup/diagonal_difference.md]]
 */
public class DiagonalDifference {

  private DiagonalDifference() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * diagonalDifference.
   */
  public static int diagonalDifference(List<List<Integer>> matrix) {
    int diag1 = 0;
    int diag2 = 0;
    int last = matrix.size() - 1;

    for (int i = 0; i < matrix.size(); i++) {
      diag1 += matrix.get(i).get(i);
      diag2 += matrix.get(last - i).get(i);
    }

    return Math.abs(diag1 - diag2);
  }
}
