package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.List;

/**
 * CountTripletsBruteForce.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/count_triplets_1.md/]]
 * @see CountTriplets
 */
public class CountTripletsBruteForce {
  private CountTripletsBruteForce() {}

  /** CountTriples. */
  static long countTriplets(List<Long> arr, long r) {

    long size = arr.size();
    long counter = 0L;

    for (int i = 0; i < size - 2; i++) {
      for (int j = i + 1; j < size - 1; j++) {
        for (int k = j + 1; k < size; k++) {

          if (r * arr.get(i) == arr.get(j) && r * arr.get(j) == arr.get(k)) {
            counter += 1;
          }
        }
      }
    }

    return counter;
  }
}
