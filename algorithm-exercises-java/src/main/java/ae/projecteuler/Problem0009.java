// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import java.text.MessageFormat;

/**
 * Special Pythagorean triplet.
 */
public class Problem0009 {

  private Problem0009() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  private class Triplet {

    Integer ta;
    Integer tb;
    Integer tc;

    Triplet(Integer a, Integer b, Integer c) {
      this.ta = a;
      this.tb = b;
      this.tc = c;
    }

    public boolean isPythagoreanTriplet() {
      return Math.pow(this.ta, 2) + Math.pow(this.tb, 2) == Math.pow(this.tc, 2);
    }
  }

  /**
   * Problem 0009.
   */
  public static Integer problem0009(Integer limit) {
    String log;
    Integer a = 1;
    Integer b = 2;
    Integer c = limit - b - a;

    Triplet found = null;

    while (a < b && found == null) {
      b = a + 1;

      while (b < c && found == null) {
        // TESTING
        log = MessageFormat.format("TESTING: a = {0} b = {1} c = {2}", a, b, c);
        logger.fine(log);
        Triplet test = new Problem0009().new Triplet(a, b, c);

        if (test.isPythagoreanTriplet()) {
          found = test;
          log = MessageFormat.format("FOUND: a = {0} b = {1} c = {2}", a, b, c);
          logger.fine(log);
        }

        // INCREASE
        b += 1;
        c = limit - b - a;
      }

      a += 1;
    }

    if (found == null) {
      return null;
    }

    log = MessageFormat.format("FOUND: a = {0}, b = {1}, c = {2}", found.ta, found.tb, found.tc);
    logger.info(log);
    log = MessageFormat.format("PRODUCT: a * b * c = {0}", found.ta * found.tb * found.tc);
    logger.info(log);

    return found.ta * found.tb * found.tc;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
