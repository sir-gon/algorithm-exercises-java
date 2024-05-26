package ae.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;

/**
 * Compare the Triplets.
 *
 * @link Problem definition [[docs/hackerrank/warmup/compare_triplets.md]]
 */
public class CompareTriplets {

  private CompareTriplets() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * compareTriplets.
   */
  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    List<Integer> awards = Arrays.asList(0, 0);

    for (int i = 0; i < a.size(); i++) {
      Integer ta = a.get(i);
      Integer tb = b.get(i);

      if (ta > tb) {
        awards.set(0, awards.get(0) + 1);
      }

      if (ta < tb) {
        awards.set(1, awards.get(1) + 1);
      }
    }

    return awards;
  }
}
