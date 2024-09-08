package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Crush (Optimized).
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/minimum_swaps_2.md]]
 */
public class MinimumSwaps2 {

  private MinimumSwaps2() {}

  /**
   * minimumSwaps.
   */
  static int minimumSwaps(int[] arr) {
    List<Integer> indexedGroup = IntStream.of(arr)
                .boxed()
                .map(t -> t - 1)
                .collect(Collectors.toList());

    int swaps = 0;
    int index = 0;
    int size = indexedGroup.size();

    while (index < size) {
      if (indexedGroup.get(index) == index) {
        index += 1;
      } else {
        int temp = indexedGroup.get(index);
        indexedGroup.set(index, indexedGroup.get(temp));
        indexedGroup.set(temp, temp);
        swaps += 1;
      }
    }
    return swaps;
  }
}
