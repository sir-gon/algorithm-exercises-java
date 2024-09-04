package ae.hackerrank.warmup;

import java.util.List;
import util.CustomLogger;

/**
 * Simple Array Sum.
 *
 * @link Problem definition [[docs/hackerrank/warmup/simple_array_sum.md]]
 */
public class SimpleArraySum {

  private SimpleArraySum() {}

  /**
   * simpleArraySum.
   */
  public static int simpleArraySum(List<Integer> ar) {
    int total = 0;

    for (Integer name : ar) {
      total += name;
    }

    String log = String.format("simpleArraySum solved: %d", total);
    CustomLogger.info(log);

    return total;
  }
}
