package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AngryFlorist.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/greedy_algorithms/angry-children.md]]
 */
public class AngryFlorist {

  private AngryFlorist() {}

  /** maxMin. */
  public static int maxMin(int k, List<Integer> arr) {
    List<Integer> sortedNums = arr.stream().collect(Collectors.toList());
    Collections.sort(sortedNums);

    int result = sortedNums.get(sortedNums.size() - 1) - sortedNums.get(0);

    for (int i = 0; i < sortedNums.size() - k + 1; i++) {
      int tmin = sortedNums.get(i);
      int tmax = sortedNums.get(i + k - 1);
      result = Math.min(result, tmax - tmin);
    }

    return result;
  }
}
