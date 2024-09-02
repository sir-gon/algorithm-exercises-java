package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.Arrays;
import java.util.List;


/**
 * Crush (Brute Force).
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/crush.md]]
 * @link Solution notes [[docs/hackerrank/interview_preparation_kit/arrays/crush_optimized-solution-notes.md]]
 */
public class CrushBruteForce {

  private CrushBruteForce() {
  }

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  private static final int INITIALIZER = 0;

  /**
   * arrayManipulation.
   */
  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // why adding 1?
    //   first slot to adjust 1-based index and
    int[] result = new int[n + 1];
    Arrays.fill(result, INITIALIZER);
    int maximum = INITIALIZER;

    for (List<Integer> query : queries) {
      int start = query.get(0);
      int end = query.get(1);
      int value = query.get(2);

      for (int i = start; i < end + 1; i++) {
        result[i] += value;
      }

      for (int current : result) {
        maximum = Math.max(current, maximum);
      }
    }

    return maximum;
  }
}
