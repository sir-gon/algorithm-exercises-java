package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FrequencyQueries.
 *
 * @link Problem definition
 *       [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/frequency-queries.md]]
 */
public class FrequencyQueries {
  private FrequencyQueries() {
  }

  private static final long __INITIAL__ = 1L;

  private static final int __INSERT__ = 1;
  private static final int __DELETE__ = 2;
  private static final int __SELECT__ = 3;

  private static final int __NOT_FOUND__ = 0;
  private static final int __FOUND__ = 1;

  /**
   * FrequencyQueries.
   */
  static List<Integer> freqQuery(List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    Map<Long, Long> valueFreqs = new HashMap<>();
    Map<Long, List<Long>> freqMap = new HashMap<>();

    for (List<Integer> query : queries) {
      int operation = query.get(0);
      long value = query.get(1);

      Long currentFreqCount = valueFreqs.getOrDefault(value, null);
      List<Long> currentFreq = freqMap.getOrDefault(value, null);
      Long newFreqCount;
      List<Long> newFreq;

      switch (operation) {
        case __INSERT__:
          newFreqCount = (currentFreqCount == null ? __INITIAL__ : currentFreqCount + 1L);
          valueFreqs.put(value, newFreqCount);

          newFreq = freqMap.getOrDefault(newFreqCount, null);

          // delete current frequency
          if (currentFreq != null) {
            freqMap.get(currentFreqCount).remove(value);
            if (freqMap.get(currentFreqCount).isEmpty()) {
              freqMap.remove(currentFreqCount);
            }
          }

          // add new frequency
          if (newFreq == null) {
            newFreq = new ArrayList<>();
            newFreq.add(value);
            freqMap.put(newFreqCount, newFreq);
          } else {
            freqMap.get(newFreqCount).add(value);
          }

          break;
        case __DELETE__:
          newFreqCount = (currentFreqCount == null ? 0 : currentFreqCount - 1L);
          if (newFreqCount > 0L) {
            valueFreqs.put(value, newFreqCount);

            newFreq = freqMap.getOrDefault(newFreqCount, null);
            // add new frequency
            if (newFreq == null) {
              newFreq = new ArrayList<>();
              newFreq.add(value);
              freqMap.put(newFreqCount, newFreq);
            } else {
              freqMap.get(newFreqCount).add(value);
            }
          } else {
            valueFreqs.remove(value);
          }

          // delete current frequency
          if (currentFreqCount != null) {
            freqMap.get(currentFreqCount).remove(value);
            if (freqMap.get(currentFreqCount).isEmpty()) {
              freqMap.remove(currentFreqCount);
            }
          }

          break;
        case __SELECT__:
          result.add(freqMap.containsKey(value) ? __FOUND__ : __NOT_FOUND__);
          break;
        default:
          break;
      }
    }

    return result;
  }
}
