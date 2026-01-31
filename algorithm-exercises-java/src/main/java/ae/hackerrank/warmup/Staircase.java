package ae.hackerrank.warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * Staricase.
 *
 * @link Problem definition [[docs/hackerrank/warmup/staircase.md]]
 */
public class Staircase {

  private Staircase() {}

  /** staircase. */
  public static String staircase(int n) {
    List<String> result = new ArrayList<>();

    for (int i = 1; i < n + 1; i++) {
      StringBuilder line = new StringBuilder();

      for (int j = 1; j < n + 1; j++) {
        if (j <= n - i) {
          line.append(" ");
        } else {
          line.append("#");
        }
      }

      result.add(line.toString());
    }
    return String.join("\n", result);
  }
}
