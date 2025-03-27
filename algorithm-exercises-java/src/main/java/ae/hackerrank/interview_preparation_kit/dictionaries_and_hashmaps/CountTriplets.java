package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CountTriplets.
 *
 * @link Problem definition
 *       [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/two-strings.md]]
 * @link Solution notes
 *       [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/two-strings-solution-notes.md]]
 */
public class CountTriplets {
  private CountTriplets() {
  }

  /**
   * CountTriplets.
   */
  static long countTriplets(List<Long> arr, long r) {

    Map<Long, Integer> a_counter = new HashMap<>();
    Map<Long, Integer> b_counter = new HashMap<>();
    Long triplets = 0L;

    for (Long item : arr) {
      if (a_counter.putIfAbsent(item, 1) != null) {
        Integer currentValue = a_counter.get(item);
        a_counter.put(item, currentValue + 1);
      }
    }

    for (Long item : arr) {
      Long j = item / r;
      Long k = item * r;
      a_counter.put(item, a_counter.get(item) - 1);
      if (b_counter.containsKey(j) && a_counter.containsKey(k) && item % r == 0) {
        triplets += b_counter.get(j) * a_counter.get(k);
      }

      Integer b_item = b_counter.get(item);

      if (b_item != null) {
        b_counter.put(item, b_item + 1);
      } else {
        b_counter.put(item, 1);
      }
    }

    return triplets;
  }
}
