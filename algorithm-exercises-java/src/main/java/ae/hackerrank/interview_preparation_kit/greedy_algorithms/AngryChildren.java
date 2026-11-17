package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import java.util.List;

/**
 * AngryChildren.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/greedy_algorithms/angry-children.md]]
 */
public class AngryChildren {

  private AngryChildren() {}

  /** maxMin. */
  public static int maxMin(int k, List<Integer> arr) {
    List<Integer> sortedNums = arr.stream().sorted().toList();

    int result = sortedNums.get(sortedNums.size() - 1) - sortedNums.get(0);

    for (int i = 0; i < sortedNums.size() - k + 1; i++) {
      int tmin = sortedNums.get(i);
      int tmax = sortedNums.get(i + k - 1);
      result = Math.min(result, tmax - tmin);
    }

    return result;
  }
}
