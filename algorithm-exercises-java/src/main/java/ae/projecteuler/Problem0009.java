// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Special Pythagorean triplet
 *
 * https://projecteuler.net/problem=9
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a² + b² = c²
 * For example, 3² + 4² = 9 + 16 = 25 = 5².
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

package ae.projecteuler;

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

    public Boolean isPythagoreanTriplet() {
      return Math.pow(this.ta, 2) + Math.pow(this.tb, 2) == Math.pow(this.tc, 2);
    }
  }

  /**
   * Problem 0009.
   */
  public static Integer problem0009(Integer _limit) {
    Integer a = 1;
    Integer b = 2;
    Integer c = _limit - b - a;

    Triplet found = null;

    while (a < b && found == null) {
      b = a + 1;

      while (b < c && found == null) {
        // TESTING
        logger.fine(String.format("TESTING: a = ${a} b = ${b} c = ${c}", a, b, c));
        Triplet test = new Problem0009().new Triplet(a, b, c);

        if (test.isPythagoreanTriplet()) {
          found = test;
          logger.fine(String.format("FOUND: a = ${a} b = ${b} c = ${c}", a, b, c));
        }

        // INCREASE
        b += 1;
        c = _limit - b - a;
      }

      a += 1;
    }

    if (found == null) {
      return null;
    }

    logger.info(String.format("FOUND: a = %d, b = %d, c = %d", found.ta, found.tb, found.tc));
    logger.info(String.format("PRODUCT: a * b * c = %d", found.ta * found.tb * found.tc));

    return found.ta * found.tb * found.tc;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
