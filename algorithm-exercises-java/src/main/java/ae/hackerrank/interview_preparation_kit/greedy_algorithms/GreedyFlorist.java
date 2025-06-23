package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GreedyFlorist.
 *
 * @link Problem definition
 *       [[docs/hackerrank/interview_preparation_kit/greedy_algorithms/greedy-florist.md]]
 * @link Solution notes
 *      [[docs/hackerrank/interview_preparation_kit/greedy_algorithms/greedy-florist-solution-notes.md]]
 */
public class GreedyFlorist {

  private GreedyFlorist() {
  }

  /**
   * getMinimumCost.
   */
  public static int getMinimumCost(int k, int[] c) {
    List<Integer> flowers = Arrays.stream(c).boxed().collect(Collectors.toList());
    Collections.sort(flowers);
    Collections.reverse(flowers);

    int totalCost = 0;
    int i = 0;

    for (Integer flowerCost : flowers) {
      int position = i / k;
      totalCost += (position + 1) * flowerCost;

      i += 1;
    }

    return totalCost;
  }
}
