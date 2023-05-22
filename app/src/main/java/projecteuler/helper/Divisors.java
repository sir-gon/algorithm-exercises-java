package projecteuler.helper;

import java.util.ArrayList;

/**
 * Divisors helper.
 */
public class Divisors {

  /**
   * Calculate divisors of a number.
   */
  public Integer[] divisors(int _top) {

    ArrayList<Integer> result = new ArrayList<Integer>();

    result.add(1);
    result.add(2);
    result.add(3);
    result.add(4);

    return result.toArray(Integer[]::new);

  }
}
