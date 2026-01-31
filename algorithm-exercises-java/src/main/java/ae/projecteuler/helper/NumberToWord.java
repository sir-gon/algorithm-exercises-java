package ae.projecteuler.helper;

import java.util.HashMap;
import java.util.Map;

// CHECKSTYLE.OFF: JavadocParagraph
/***
 * NumberToWord.
 */
public class NumberToWord {
  private NumberToWord() {}

  protected static final Map<String, String> dictionary = new HashMap<>();

  public static final String CENTS = "hundred";
  public static final String MILLS = "thousand";

  static {
    dictionary.put("1", "one");
    dictionary.put("2", "two");
    dictionary.put("3", "three");
    dictionary.put("4", "four");
    dictionary.put("5", "five");
    dictionary.put("6", "six");
    dictionary.put("7", "seven");
    dictionary.put("8", "eight");
    dictionary.put("9", "nine");
    dictionary.put("10", "ten");
    dictionary.put("11", "eleven");
    dictionary.put("12", "twelve");
    dictionary.put("13", "thirteen");
    dictionary.put("14", "fourteen");
    dictionary.put("15", "fifteen");
    dictionary.put("16", "sixteen");
    dictionary.put("17", "seventeen");
    dictionary.put("18", "eighteen");
    dictionary.put("19", "nineteen");
    dictionary.put("20", "twenty");
    dictionary.put("30", "thirty");
    dictionary.put("40", "forty");
    dictionary.put("50", "fifty");
    dictionary.put("60", "sixty");
    dictionary.put("70", "seventy");
    dictionary.put("80", "eighty");
    dictionary.put("90", "ninety");
    dictionary.put("100", CENTS);
    dictionary.put("1000", MILLS);
  }

  /***
   * numberToWord.
   */
  public static String numberToWord(int value) throws Exception {
    if (value < 0) {
      throw new IllegalArgumentException("Invalid value");
    }

    String strValue = new BigNum(value).toString();

    // 1 to 19
    if (value <= 19) {
      return dictionary.get(strValue);
    } else if (value <= 99) {
      // 20 to 99
      int dec = (int) Math.floor((double) value / 10) * 10;
      int unit = (int) Math.floor((double) value % 10);

      if (unit == 0) {
        return dictionary.get(Integer.toString(dec));
      }

      return String.format(
          "%s-%s", dictionary.get(Integer.toString(dec)), dictionary.get(Integer.toString(unit)));

    } else if (value <= 999) {
      // 100 to 999
      int rest = (int) Math.floor((double) value % 100);
      int cent = (int) Math.floor((double) value / 100);

      if (rest == 0) {
        return String.format("%s %s", dictionary.get(Integer.toString(cent)), NumberToWord.CENTS);
      }

      return String.format(
          "%s %s and %s",
          dictionary.get(Integer.toString(cent)), NumberToWord.CENTS, numberToWord(rest));
    } else if (value == 1000) {
      // up to 1000
      int mills = (int) Math.floor((double) value / 1000);

      return String.format("%s %s", dictionary.get(Integer.toString(mills)), NumberToWord.MILLS);
    }

    throw new IllegalArgumentException("Invalid value");
  }
}
// CHECKSTYLE.ON: JavadocParagraph
