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
  private static final int __EXISTS__ = 1;

  /**
   * FrequencyQueries.
   */
  static List<Integer> freqQuery(List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    Map<Long, Long> valueFreqs = new HashMap<>();
    Map<Long, Map<Long, Integer>> freqMap = new HashMap<>();

    for (List<Integer> query : queries) {
      int operation = query.get(0);
      long value = query.get(1);
      Long currentFreqCount = valueFreqs.getOrDefault(value, null);
      Long newFreqCount;
      Map<Long, Integer> currentFreq;
      Map<Long, Integer> newFreq;

      switch (operation) {
        case __INSERT__:
          newFreqCount = (currentFreqCount == null ? __INITIAL__ : currentFreqCount + 1L);
          valueFreqs.put(value, newFreqCount);

          // delete current value from frequency map
          currentFreq = freqMap.getOrDefault(currentFreqCount, null);
          if (currentFreq != null) {
            currentFreq.remove(value);
            if (currentFreq.isEmpty()) {
              freqMap.remove(currentFreqCount);
            }
          }

          // add new value to frequency map
          newFreq = freqMap.getOrDefault(newFreqCount, null);
          if (newFreq == null) {
            newFreq = new HashMap<>();
            newFreq.put(value, __EXISTS__);
            freqMap.put(newFreqCount, newFreq);
          }

          break;
        case __DELETE__:
          newFreqCount = (currentFreqCount == null ? 0L : currentFreqCount - 1L);
          valueFreqs.put(value, newFreqCount);

          if (newFreqCount <= 0L) {
            valueFreqs.remove(value);
          } else {
            valueFreqs.put(value, newFreqCount);

            // add new value to frequency map
            newFreq = freqMap.getOrDefault(newFreqCount, null);
            if (newFreq == null) {
              newFreq = new HashMap<>();
              newFreq.put(value, __EXISTS__);
              freqMap.put(newFreqCount, newFreq);
            }
          }

          // delete current value from frequency map
          currentFreq = freqMap.getOrDefault(currentFreqCount, null);
          if (currentFreq != null) {
            currentFreq.remove(value);
            if (currentFreq.isEmpty()) {
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
