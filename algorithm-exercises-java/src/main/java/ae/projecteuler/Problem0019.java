// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Counting Sundays
 *
 * https://projecteuler.net/problem=19
 *
 * You are given the following information, but you may prefer
 * to do some research for yourself.
 *
 *  1 Jan 1900 was a Monday.
 *  Thirty days has September,
 *    April, June and November.
 *    All the accumulatedRemainder have thirty-one,
 *    Saving February alone,
 *    Which has twenty-eight, rain or shine.
 *    And on leap years, twenty-nine.
 *  A leap year occurs on any year evenly divisible by 4,
 *    but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the
 * twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

package ae.projecteuler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Problem 0019.
 */
public class Problem0019 {

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();
  private static final String __FEBRUARY__KEY__ = "FEBRUARY";

  /**
   * Problem 0019.
   */
  public static Integer problem0019(
      int dayOfWeek, // __SUNDAY__,
      int sinceYear, // 1901,
      int untilYear // 2000
  ) {
    int resultCount = 0;
    int accumulatedRemainder = 0;
    int excess = 0;

    // copy days in months
    Map<String, Integer> daysInMonth = new LinkedHashMap<String, Integer>();
    Set<Entry<String, Integer>>
        entries = ae.projecteuler.constants.Date.__DAYS_IN_MONTH__.entrySet();
    for (Map.Entry<String, Integer> mapEntry : entries) {
      daysInMonth.put(mapEntry.getKey(), mapEntry.getValue());
    }

    for (int year = 1900; year < untilYear + 1; year++) {

      int leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 1 : 0;
      daysInMonth.put(__FEBRUARY__KEY__, 28 + leap);

      if (leap != 0) {
        logger.fine(String.format("Year %d has a leap-day", year));
      }

      Set<Entry<String, Integer>> months = daysInMonth.entrySet();
      for (Map.Entry<String, Integer> mapEntry : months) {
        String month = mapEntry.getKey();
        Integer days = mapEntry.getValue();

        logger.fine(String.format("Year: %d | Month: %s | days: %d", year, month, days));

        accumulatedRemainder += days % 7;
        if (accumulatedRemainder % 7 == dayOfWeek) {
          if (year <= sinceYear) {
            excess += 1;
          }
          resultCount += 1;
        }

      }
    }

    Integer result = resultCount - excess;

    logger.info(String.format("Problem 00019 solved: %d", result));

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
