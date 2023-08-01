// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Number letter counts
 *
 * https://projecteuler.net/problem=17
 *
 *
 * If the numbers 1 to 5 are written out in words:
 * one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
 * letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written
 * out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342
 * (three hundred and forty-two) contains 23 letters and
 * 115 (one hundred and fifteen) contains 20 letters. The use of "and"
 * when writing out numbers is in compliance with British usage.
 */

package ae.projecteuler;

import ae.projecteuler.helper.NumberToWord;

/**
 * Problem 0017.
 */
public class Problem0017 {

  private Problem0017() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0017.
   */
  public static Integer problem0017(int _init, int _last) throws Exception {

    int acum = 0;

    for (int i = _init; i <= _last; i++) {
      String word = NumberToWord.number_to_word(i);

      String replaced = word.replaceAll("[^A-Za-z0-9]", "");

      acum += replaced.length();

      logger.fine(String.format("acum: %d => word: %s", acum, word));
    }

    logger.info(String.format("Problem 00017 solved: %d", acum));

    return acum;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
