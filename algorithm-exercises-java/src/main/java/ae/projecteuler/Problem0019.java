package ae.projecteuler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import util.Log;

/**
 * Counting Sundays.
 *
 * @link Problem definition [[docs/projecteuler/problem0019.md]]
 */
public class Problem0019 {

  private Problem0019() {}

  private static final String FEBRUARY_KEY = "FEBRUARY";

  private static Map<String, Integer> copyDaysInMonth() {
    Map<String, Integer> daysInMonth = new LinkedHashMap<>();
    Set<Entry<String, Integer>> entries = ae.projecteuler.constants.Date.daysInMonth().entrySet();
    for (Map.Entry<String, Integer> mapEntry : entries) {
      daysInMonth.put(mapEntry.getKey(), mapEntry.getValue());
    }

    return daysInMonth;
  }

  /** Problem 0019. */
  public static Integer problem0019(int dayOfWeek, int sinceYear, int untilYear) {
    String log;
    int resultCount = 0;
    int accumulatedRemainder = 0;
    int excess = 0;

    // copy days in months
    Map<String, Integer> daysInMonth = copyDaysInMonth();

    for (int year = 1900; year < untilYear + 1; year++) {

      int leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 1 : 0;
      daysInMonth.put(FEBRUARY_KEY, 28 + leap);

      Set<Entry<String, Integer>> months = daysInMonth.entrySet();
      for (Map.Entry<String, Integer> mapEntry : months) {
        String month = mapEntry.getKey();
        Integer days = mapEntry.getValue();

        log = String.format("Year: %d | Month: %s | days: %d", year, month, days);
        Log.debug(log);

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

    log = String.format("Problem 00019 solved: %d", result);
    Log.info(log);

    return result;
  }
}
