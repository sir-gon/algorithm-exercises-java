package ae.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Plus Minus.
 *
 * @link Problem definition [[docs/hackerrank/warmup/plus_minus.md]]
 */
public class PlusMinus {

  private PlusMinus() {
  }

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * plusMinus.
   */
  public static String plusMinus(List<Integer> arr) {

    int positives = 0;
    int negatives = 0;
    int zeros = 0;

    for (int x : arr) {
      if (x > 0) {
        positives += 1;
      }
      if (x < 0) {
        negatives += 1;
      }
      if (x == 0) {
        zeros += 1;
      }
    }

    List<String> result = new ArrayList<>();
    result.add(String.format(Locale.ROOT, "%.6f", (double) positives / arr.size()));
    result.add(String.format(Locale.ROOT, "%.6f", (double) negatives / arr.size()));
    result.add(String.format(Locale.ROOT, "%.6f", (double) zeros / arr.size()));

    return String.join("\n", result);
  }
}
