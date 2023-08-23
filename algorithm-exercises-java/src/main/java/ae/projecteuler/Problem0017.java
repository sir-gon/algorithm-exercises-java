package ae.projecteuler;

import ae.projecteuler.helper.NumberToWord;

/**
 * Number letter counts.
 *
 * @link Problem definition [[docs/projecteuler/problem0017.md]]
 */
public class Problem0017 {

  private Problem0017() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0017.
   */
  public static Integer problem0017(int init, int last) throws Exception {

    int acum = 0;
    String log;

    for (int i = init; i <= last; i++) {
      String word = NumberToWord.numberToWord(i);

      String replaced = word.replaceAll("[^A-Za-z0-9]", "");

      acum += replaced.length();

      log = String.format("acum: %d => word: %s", acum, word);
      logger.fine(log);
    }

    log = String.format("Problem 00017 solved: %d", acum);
    logger.info(log);

    return acum;
  }
}
