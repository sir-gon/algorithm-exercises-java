package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.Arrays;
import java.util.List;


/**
 * Arrays Left Rotation.
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/ctci_array_left_rotation.md]]
 */
public class CrushOptimized {

  private CrushOptimized() {
  }

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * arrayManipulation.
   */
  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // why adding 2?
    //   first slot to adjust 1-based index and
    //   last slot for storing accum_sum result
    int[] result = new int[n + 2];
    Arrays.fill(result, 0);
    int maximum = 0;

    for (List<Integer> query : queries) {
      int a = query.get(0);
      int b = query.get(1);
      int k = query.get(2);

      // Prefix
      result[a] += k;
      result[b + 1] -= k;

      int accumSum = 0;
      for (int value : result) {
        accumSum += value;
        maximum = Math.max(maximum, accumSum);
      }
    }

    return maximum;
  }
}
