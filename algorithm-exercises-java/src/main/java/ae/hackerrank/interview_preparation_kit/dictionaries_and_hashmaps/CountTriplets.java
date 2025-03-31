package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CountTriplets.
 *
 * @link Problem definition
 *       [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/count_triplets_1.md/]]
 *
 * @link Solution Notes
 *       [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/count_triplets_1-solution-notes.md/]]
 */
public class CountTriplets {
  private CountTriplets() {
  }

  /**
   * CountTriplets.
   */
  static long countTriplets(List<Long> arr, long r) {

    Map<Long, Long> aCounter = new HashMap<>();
    Map<Long, Long> bCounter = new HashMap<>();
    long triplets = 0L;

    for (Long item : arr) {
      if (aCounter.putIfAbsent(item, 1L) != null) {
        Long currentValue = aCounter.get(item);
        aCounter.put(item, currentValue + 1L);
      }
    }

    long prevItemCount;
    long nextItemCount;
    Long currentItemCount;

    for (Long item : arr) {
      Long j = item / r;
      Long k = item * r;

      aCounter.put(item, aCounter.get(item) - 1L);

      prevItemCount = bCounter.get(j) != null ? bCounter.get(j) : 0L;
      nextItemCount = aCounter.get(k) != null ? aCounter.get(k) : 0L;
      if (item % r == 0) {
        triplets += prevItemCount * nextItemCount;
      }

      currentItemCount = bCounter.get(item);
      bCounter.put(item, currentItemCount != null ? currentItemCount + 1L : 1L);
    }

    return triplets;
  }
}
