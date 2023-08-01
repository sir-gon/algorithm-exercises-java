package ae.projecteuler.constants;

import java.util.LinkedHashMap;

/**
 * Dates.
 */
public class Date {
  public static final int __SUNDAY__ = 0;
  public static final int __MONDAY__ = 1;
  public static final int __TUESDAY__ = 2;
  public static final int __WEDNESDAY__ = 3;
  public static final int __THURSDAY__ = 4;
  public static final int __FRIDAY__ = 5;
  public static final int __SATURDAY__ = 6;

  public static final int __JANUARY__ = 0;
  public static final int __FEBRUARY__ = 1;
  public static final int __MARCH__ = 2;
  public static final int __APRIL__ = 3;
  public static final int __MAY__ = 4;
  public static final int __JUNE__ = 5;
  public static final int __JULY__ = 6;
  public static final int __AUGUST__ = 7;
  public static final int __SEPTEMBER__ = 8;
  public static final int __OCTOBER__ = 9;
  public static final int __NOVEMBER__ = 10;
  public static final int __DECEMBER__ = 11;

  public static final LinkedHashMap<String, Integer>
      __DAYS_IN_MONTH__ = new LinkedHashMap<String, Integer>();

  static {
    __DAYS_IN_MONTH__.put("JANUARY", 31);
    __DAYS_IN_MONTH__.put("FEBRUARY", 28);
    __DAYS_IN_MONTH__.put("MARCH", 31);
    __DAYS_IN_MONTH__.put("APRIL", 30);
    __DAYS_IN_MONTH__.put("MAY", 31);
    __DAYS_IN_MONTH__.put("JUNE", 30);
    __DAYS_IN_MONTH__.put("JULY", 31);
    __DAYS_IN_MONTH__.put("AUGUST", 31);
    __DAYS_IN_MONTH__.put("SEPTEMBER", 30);
    __DAYS_IN_MONTH__.put("OCTOBER", 31);
    __DAYS_IN_MONTH__.put("NOVEMBER", 30);
    __DAYS_IN_MONTH__.put("DECEMBER", 31);
  }
}
