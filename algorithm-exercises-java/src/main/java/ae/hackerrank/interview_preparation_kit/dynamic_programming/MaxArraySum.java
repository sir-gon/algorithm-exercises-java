// @link Problem definition
// [[docs/hackerrank/interview_preparation_kit/dynamic_programming/max_array_sum.md]]

package ae.hackerrank.interview_preparation_kit.dynamic_programming;

import java.util.List;

/**
 * MaxArraySum.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/dynamic_programming/max_array_sum.md]]
 * @link Solution notes
 *     [[docs/hackerrank/interview_preparation_kit/dynamic_programming/max_array_sum-solution-notes.md]]
 */
public class MaxArraySum {
  private MaxArraySum() {}

  /** maxSubsetSum. */
  public static int maxSubsetSum(List<Integer> arr) {
    int total = arr.size();

    if (total == 0) { // Edge case
      return 0;
    }

    if (total == 1) { // Edge case
      return arr.get(0);
    }

    // Base case start from index 0 and 1
    int tMax = Math.max(arr.get(0), arr.get(1));
    arr.set(1, tMax);

    for (int i = 2; i < total; i++) {
      tMax = Math.max(arr.get(i - 2) + arr.get(i), tMax); // Max uptill now
      tMax = Math.max(arr.get(i), tMax); // Max in special case where
      // arr[i] + previous max is still less than arr[i]
      // update our inplace array with max for future calculations
      arr.set(i, tMax);
    }

    return tMax;
  }
}
