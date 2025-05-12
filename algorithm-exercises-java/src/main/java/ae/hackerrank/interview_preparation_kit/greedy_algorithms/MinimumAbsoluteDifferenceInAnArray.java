package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MinimumAbsoluteDifferenceInAnArray.
 *
 * @link Problem definition
 *       [[docs/hackerrank/interview_preparation_kit/greedy_algorithms/minimum-absolute-difference-in-an-array.md]]
 */
public class MinimumAbsoluteDifferenceInAnArray {

  private MinimumAbsoluteDifferenceInAnArray() {
  }

  /**
   * minimumAbsoluteDifference.
   */
  public static int minimumAbsoluteDifference(List<Integer> arr) {
    List<Integer> sortedNums = arr.stream().collect(Collectors.toList());
    Collections.sort(sortedNums);

    // Find the minimum absolute difference
    int result = 0;
    boolean resultEmpty = true;

    for (int i = 0; i < sortedNums.size() - 1; i++) {
      int aValue = sortedNums.get(i);
      int bValue = sortedNums.get(i + 1);

      int diff = Math.abs(aValue - bValue);

      if (resultEmpty) {
        result = diff;
        resultEmpty = false;
      } else {
        result = Math.min(result, diff);
      }
    }

    return result;
  }
}
