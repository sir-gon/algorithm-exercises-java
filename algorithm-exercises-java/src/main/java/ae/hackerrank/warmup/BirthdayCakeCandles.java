package ae.hackerrank.warmup;

import java.util.List;

/**
 * Birthday Cake Candles.
 *
 * @link Problem definition [[docs/hackerrank/warmup/birthday_cake_candles.md]]
 */
public class BirthdayCakeCandles {

  private BirthdayCakeCandles() {
  }

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * birthdayCakeCandles.
   */
  public static int birthdayCakeCandles(List<Integer> candles) {
    if (candles == null || candles.isEmpty()) {
      throw new IllegalArgumentException("Parameter cannot be empty");
    }

    int counter = 0;
    int maximum = candles.get(0);

    for (Integer element : candles) {
      if (element > maximum) {
        maximum = element;
        counter = 1;
      } else {
        if (element == maximum) {
          counter += 1;
        }
      }
    }

    return counter;
  }
}
