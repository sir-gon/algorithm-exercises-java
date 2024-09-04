package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.Arrays;
import java.util.List;


/**
 * Crush (Optimized).
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/crush.md]]
 * @link Solution notes [[docs/hackerrank/interview_preparation_kit/arrays/crush_optimized-solution-notes.md]]
 */
public class CrushOptimized {

  private CrushOptimized() {}

  /**
   * arrayManipulation.
   */
  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // why adding 2?
    //   first slot to adjust 1-based index and
    //   last slot for storing accumSum result
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
