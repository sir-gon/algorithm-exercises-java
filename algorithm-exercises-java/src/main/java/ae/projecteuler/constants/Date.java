package ae.projecteuler.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/** Dates. */
public class Date {
  private Date() {}

  public static final int SUNDAY = 0;
  public static final int MONDAY = 1;
  public static final int TUESDAY = 2;
  public static final int WEDNESDAY = 3;
  public static final int THURSDAY = 4;
  public static final int FRIDAY = 5;
  public static final int SATURDAY = 6;

  public static final int JANUARY = 0;
  public static final int FEBRUARY = 1;
  public static final int MARCH = 2;
  public static final int APRIL = 3;
  public static final int MAY = 4;
  public static final int JUNE = 5;
  public static final int JULY = 6;
  public static final int AUGUST = 7;
  public static final int SEPTEMBER = 8;
  public static final int OCTOBER = 9;
  public static final int NOVEMBER = 10;
  public static final int DECEMBER = 11;

  protected static final Map<String, Integer> DAYS_IN_MONTH = new LinkedHashMap<>();

  static {
    DAYS_IN_MONTH.put("JANUARY", 31);
    DAYS_IN_MONTH.put("FEBRUARY", 28);
    DAYS_IN_MONTH.put("MARCH", 31);
    DAYS_IN_MONTH.put("APRIL", 30);
    DAYS_IN_MONTH.put("MAY", 31);
    DAYS_IN_MONTH.put("JUNE", 30);
    DAYS_IN_MONTH.put("JULY", 31);
    DAYS_IN_MONTH.put("AUGUST", 31);
    DAYS_IN_MONTH.put("SEPTEMBER", 30);
    DAYS_IN_MONTH.put("OCTOBER", 31);
    DAYS_IN_MONTH.put("NOVEMBER", 30);
    DAYS_IN_MONTH.put("DECEMBER", 31);
  }

  public static Map<String, Integer> daysInMonth() {
    return Date.DAYS_IN_MONTH;
  }
}
