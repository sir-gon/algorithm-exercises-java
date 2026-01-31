package ae.hackerrank.warmup;

/**
 * Time Conversion.
 *
 * @link Problem definition [[docs/hackerrank/warmup/time_conversion.md]]
 */
public class TimeConversion {

  private TimeConversion() {}

  /** timeConversion. */
  public static String timeConversion(String input) {
    String meridian = input.substring(input.length() - 2);
    meridian = meridian.toLowerCase();

    String timeStr = input.substring(0, input.length() - 2);
    String[] time = timeStr.split(":");

    int hour = Integer.parseInt(time[0]);

    hour = hour % 12;

    if (meridian.equals("pm")) {
      hour += 12;
    }

    time[0] = String.format("%02d", hour);

    return String.join(":", time);
  }
}
