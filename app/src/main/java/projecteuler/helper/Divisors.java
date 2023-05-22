package projecteuler.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Divisors helper.
 */
public class Divisors {

  /**
   * Calculate divisors of a number.
   */
  public Integer[] divisors(int _top) {
    Integer top = Math.abs(_top);
    Integer target = Math.abs(_top);

    ArrayList<Integer> divs = new ArrayList<Integer>();

    divs.add(1);

    if (top == 1) {
      return divs.toArray(Integer[]::new);
    }

    int i = 2;
    while (i <= top) {

      top = target / i;

      if (top > 2 && target % i == 0) {
        divs.add(i);

        if (i < top) {
          divs.add(target / i);
        }
      }
      i += 1;
    }

    divs.add(target);

    // sort divisors
    Integer[] answer = divs.toArray(Integer[]::new);
    Arrays.sort(answer);

    return answer;
  }
}
