package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.List;

/**
 * New Year Chaos.
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/new_year_chaos.md]]
 */
public class NewYearChaos {

  private NewYearChaos() {}

  static final String TOO_CHAOTIC_ERROR = "Too chaotic";
  static final int NEW_YEAR_CHAOS_TOLERANCE = 2;

  /** minimumBribesCalculate. */
  @SuppressWarnings("java:S6885")
  public static Integer minimumBribesCalculate(List<Integer> q) {
    int bribes = 0;
    int i = 0;

    for (Integer value : q) {
      int position = i + 1;

      if (value - position > NEW_YEAR_CHAOS_TOLERANCE) {
        throw new IllegalStateException(TOO_CHAOTIC_ERROR);
      }

      List<Integer> fragment =
          q.subList(Math.min(Math.max(value - NEW_YEAR_CHAOS_TOLERANCE, 0), i), i);

      for (Integer k : fragment) {
        if (k > value) {
          bribes += 1;
        }
      }
      i += 1;
    }

    return bribes;
  }

  /** minimumBribes. */
  public static String minimumBribesText(List<Integer> q) {
    try {
      Integer bribes = minimumBribesCalculate(q);
      return String.format("%d", bribes);
    } catch (IllegalStateException e) {
      return String.format(e.getMessage());
    }
  }

  /** minimumBribesText. */
  @SuppressWarnings("java:S106")
  public static void minimumBribes(List<Integer> q) {
    System.out.println(minimumBribesText(q));
  }
}
