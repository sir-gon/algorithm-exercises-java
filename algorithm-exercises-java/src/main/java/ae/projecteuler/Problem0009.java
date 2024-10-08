package ae.projecteuler;

import util.Log;

/**
 * Special Pythagorean triplet.
 *
 * @link Problem definition [[docs/projecteuler/problem0009.md]]
 */
public class Problem0009 {

  private Problem0009() {}


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
        log = String.format("TESTING: a = %d b = %d c = %d", a, b, c);
        Log.debug(log);
        Triplet test = new Problem0009().new Triplet(a, b, c);

        if (test.isPythagoreanTriplet()) {
          found = test;
          log = String.format("FOUND: a = %d b = %d c = %d", a, b, c);
          Log.debug(log);
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

    log = String.format("FOUND: a = %d, b = %d, c = %d", found.ta, found.tb, found.tc);
    Log.info(log);
    log = String.format("PRODUCT: a * b * c = %d", found.ta * found.tb * found.tc);
    Log.info(log);

    return found.ta * found.tb * found.tc;
  }
}
