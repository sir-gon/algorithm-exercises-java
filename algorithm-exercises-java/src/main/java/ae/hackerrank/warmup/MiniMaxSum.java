package ae.hackerrank.warmup;

import java.util.List;

/**
 * Mini-Max Sum.
 *
 * @link Problem definition [[docs/hackerrank/warmup/mini_max_sum.md]]
 */
public class MiniMaxSum {

  private MiniMaxSum() {}

  /**
   * miniMaxSum.
   *
   * @throws IllegalArgumentException arr Must have elements
   */
  public static String miniMaxSum(List<Integer> arr) throws IllegalArgumentException {
    if (arr == null || arr.isEmpty()) {
      throw new IllegalArgumentException("Parameter cannot be empty");
    }

    int tsum = 0;
    int tmin = arr.get(0);
    int tmax = arr.get(0);

    for (int value : arr) {
      tsum += value;

      tmin = Math.min(tmin, value);
      tmax = Math.max(tmax, value);
    }

    return String.format("%d %d", tsum - tmax, tsum - tmin);
  }
}
